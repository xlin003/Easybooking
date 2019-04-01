package autentificacion.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAutentificacionManager extends Remote {

	public boolean iniciarSesion(String mail, String password, String choice) throws RemoteException;
	
	public void registrarUsuario() throws RemoteException;

	public String getName()throws RemoteException;
}
