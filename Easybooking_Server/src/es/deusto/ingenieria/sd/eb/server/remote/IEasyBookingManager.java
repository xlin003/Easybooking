package es.deusto.ingenieria.sd.eb.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import es.deusto.ingenieria.sd.eb.server.data.dto.ReservaDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public interface IEasyBookingManager extends Remote {

	public List<VueloDTO> buscarVuelo(String flightArgs) throws RemoteException;

	public void realizarPago() throws RemoteException;

	public void registrarUsuario(UsuarioDTO u) throws RemoteException;

	public String getUserName() throws RemoteException;

	public boolean iniciarSesion(UsuarioDTO u) throws RemoteException;

	public int calcularPago(VueloDTO vuelo, int numPasajeros) throws RemoteException;

	public List<ReservaDTO> getBookingList(UsuarioDTO u) throws RemoteException;

	public void clearFlightList() throws RemoteException;

	public void storeFlight(VueloDTO fdto, ReservaDTO bdto) throws RemoteException;

	public void updateDB() throws RemoteException;

	public void storeBooking(VueloDTO f, UsuarioDTO u, int seats) throws RemoteException;

	public void deleteBooking(long cod, VueloDTO f, UsuarioDTO u, int seats) throws RemoteException;

	public long getBookingId() throws RemoteException;

}
