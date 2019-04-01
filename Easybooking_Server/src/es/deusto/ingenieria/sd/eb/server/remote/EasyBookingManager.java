package es.deusto.ingenieria.sd.eb.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.dao.EasybookingDAO;
import es.deusto.ingenieria.sd.eb.server.dao.IEasybookingDAO;
import es.deusto.ingenieria.sd.eb.server.data.Reserva;
import es.deusto.ingenieria.sd.eb.server.data.Usuario;
import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.data.assembler.EBAssembler;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;
import es.deusto.ingenieria.sd.eb.server.gateway.AirlineGatewayFactory;
import es.deusto.ingenieria.sd.eb.server.gateway.GatewayAutentificacion;
import es.deusto.ingenieria.sd.eb.server.gateway.IAirlineGateway;
import es.deusto.ingenieria.sd.eb.server.gateway.IGatewayAutentificacion;

public class EasyBookingManager extends UnicastRemoteObject implements IEasyBookingManager {

	private static final long serialVersionUID = 1L;
	private List<ReservaDTO> bookingList = new ArrayList<ReservaDTO>();
	private List<VueloDTO> flightList = new ArrayList<VueloDTO>();
	private List<List<VueloDTO>> list = new ArrayList<List<VueloDTO>>();
	private IEasybookingDAO dao;
	private IGatewayAutentificacion gwa;

	private RMIServiceLocator rsl;
	private String serverName;
	private String args[];
	private String flightArgs;
	private EBAssembler eba;
	private Reserva booking;
	private long id;

	public EasyBookingManager(String[] args) throws RemoteException {
		super();
		gwa = new GatewayAutentificacion(args);
		rsl = new RMIServiceLocator();
		eba = new EBAssembler();
		rsl.setService(args);
		this.args = args;
	}

	public void updateDB() {
		dao = new EasybookingDAO();
	}

	public void storeFlight(VueloDTO fdto, ReservaDTO bdto) {
		dao = new EasybookingDAO();
		Vuelo flight = eba.flightAssembler(fdto);
		dao.storeFlight(flight);
	}

	public void storeBooking(VueloDTO f, UsuarioDTO u, int seats) {
		Vuelo flight = eba.flightAssembler(f);
		Usuario user = eba.userAssembler(u);
		booking = new Reserva(id, user, flight, seats);
		user.addBooking(booking);
		flight.addBooking(booking);
		new EasybookingDAO().storeBooking(booking);
	}

	public void deleteBooking(long cod, VueloDTO f, UsuarioDTO u, int seats) {
		Vuelo flight = eba.flightAssembler(f);
		Usuario user = eba.userAssembler(u);
		user.removeBoobking(booking);
		flight.removeBoobking(booking);
		new EasybookingDAO().deleteBooking(cod);
	}

	public long getBookingId() {
		return booking.getId();
	}

	public List<ReservaDTO> getBookingList(UsuarioDTO u) {
		dao = new EasybookingDAO();
		Usuario user = new EBAssembler().userAssembler(u);
		List<ReservaDTO> bldto = new ArrayList<>();
		List<Reserva> bl = new ArrayList<>();
		System.out.println("   £ Getting Bookings...");

		bl = new EasybookingDAO().getBookingList(user);
		System.out.println(bl.size() + "<size>~");

		bldto = new EBAssembler().bookingsAssemblerDTO(bl);
		System.out.println("correctly assembled");

		return bldto;
	}

	@Override
	public List<VueloDTO> buscarVuelo(String flightArgs) throws RemoteException {
		// List<VueloDTO> mylist = new ArrayList<VueloDTO>();
		List<IAirlineGateway> airgwlist;
		this.flightArgs = flightArgs + "#" + args[5] + "#" + args[6] + "#" + args[9];
		System.out.println(this.flightArgs);
		AirlineGatewayFactory gwf = new AirlineGatewayFactory(args);
		// System.out.println(gwf.checkAirNum(args[9]) + "<airnum>");
		airgwlist = gwf.createAirlineGateway(this.flightArgs);
		for (int i = 0; i < gwf.checkAirNum(args[9]); i++) {
			list.add(airgwlist.get(i).buscarVuelo(this.flightArgs));
		}
		for (int j = 1; j < list.size(); j++) {
			for (int k = 0; k < list.get(j).size(); k++)
				list.get(0).add(list.get(j).get(k));
		}
		System.out.println(list.get(0).size() + "<list size>");
		flightList = list.get(0);

		return flightList;
	}

	public void clearFlightList() {
		list.clear();
		flightList.clear();
	}

	@Override
	public void realizarPago() {

	}

	@Override
	public void registrarUsuario(UsuarioDTO u) throws RemoteException {
		rsl.getAutentificacionService().registrarUsuario();
	}

	@Override
	public boolean iniciarSesion(UsuarioDTO u) throws RemoteException {
		return gwa.iniciarSesion(u);
	}

	public String getUserName() throws RemoteException {
		return rsl.getAutentificacionService().getName();
	}

	@Override
	public int calcularPago(VueloDTO vuelo, int numPasajeros) {
		return numPasajeros;

	}

	public String getName() {
		return serverName;
	}

}
