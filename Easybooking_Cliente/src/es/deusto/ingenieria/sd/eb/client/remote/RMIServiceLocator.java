package es.deusto.ingenieria.sd.eb.client.remote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.eb.server.remote.IEasyBookingManager;

public class RMIServiceLocator {

	private IEasyBookingManager service;


	public RMIServiceLocator() {
		
	}

	public IEasyBookingManager getService() {
		return service;
	}

	public void setService(String ip, String port, String serviceName) {
		String name = "//" + ip + ":" + port + "/" + serviceName;
		try {
			service =  (IEasyBookingManager) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
