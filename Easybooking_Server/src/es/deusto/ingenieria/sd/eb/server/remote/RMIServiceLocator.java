package es.deusto.ingenieria.sd.eb.server.remote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import autentificacion.server.remote.IAutentificacionManager;
import lufthansa.server.remote.ILufthansaManager;

public class RMIServiceLocator {

	private IAutentificacionManager autentificacionService;
	private ILufthansaManager lufthansaService;

	public RMIServiceLocator() {

	}

	public void setService(String[] args) {
		String name = "//" + args[0] + ":" + args[1] + "/" + args[3];
		String name1 = "//" + args[0] + ":" + args[1] + "/" + args[4];
		
		try {
			autentificacionService = (IAutentificacionManager) java.rmi.Naming.lookup(name);
			lufthansaService = (ILufthansaManager) java.rmi.Naming.lookup(name1);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public IAutentificacionManager getAutentificacionService() {
		
		return autentificacionService;
	}
	
	public ILufthansaManager getLufthansaService() {

		return lufthansaService;
	}
}
