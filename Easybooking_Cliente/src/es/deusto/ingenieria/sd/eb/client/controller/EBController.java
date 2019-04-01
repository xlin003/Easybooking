package es.deusto.ingenieria.sd.eb.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import es.deusto.ingenieria.sd.eb.client.gui.EBWindow;
import es.deusto.ingenieria.sd.eb.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.eb.server.data.assembler.EBAssembler;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class EBController {

	private RMIServiceLocator rsl;
	private EBAssembler eba;

	public EBController(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
		new EBWindow(this);
	}

	public void exit() {
		System.exit(0);
	}

	public List<VueloDTO> buscarVuelos(String originCity, String destinationCity, String date, int numPassenger)
			throws RemoteException {
		List<VueloDTO> flightList = new ArrayList<>();
		String flightArgs = originCity + '#' + destinationCity + '#' + date + '#' + numPassenger;
		flightList = rsl.getService().buscarVuelo(flightArgs);
		return flightList;
	}

	public void storeBooking(VueloDTO flight, UsuarioDTO user, int seats) {
		try {
			rsl.getService().storeBooking(flight, user, seats);
			rsl.getService().updateDB();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void deleteBooking(long cod, VueloDTO flight, UsuarioDTO user, int seats) throws RemoteException {
		rsl.getService().deleteBooking(cod, flight, user, seats);
		rsl.getService().updateDB();
	}

	public List<ReservaDTO> getBookings(UsuarioDTO udto) throws RemoteException {
		return rsl.getService().getBookingList(udto);
	}

	public void clearList() {
		try {
			rsl.getService().clearFlightList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void deleteFlight(VueloDTO fdto) {
		try {
			rsl.getService().deleteFlight(fdto);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void registrarse(UsuarioDTO u) throws RemoteException {
		rsl.getService().registrarUsuario(u);
	}

	public boolean iniciarSesion(UsuarioDTO u) throws RemoteException {
		return rsl.getService().iniciarSesion(u);
	}

	public String getUserName() throws RemoteException {
		return rsl.getService().getUserName();
	}

	public String elegirMetodoPago(UsuarioDTO u) {
		return null;

	}

	public static void main(String[] args) throws RemoteException {
		new EBController(args);
	}

}
