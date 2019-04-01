package es.deusto.ingenieria.sd.eb.server.gateway;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;
import es.deusto.ingenieria.sd.eb.server.remote.RMIServiceLocator;

public class GatewayAutentificacion implements IGatewayAutentificacion {
	private RMIServiceLocator rsl;

	public GatewayAutentificacion(String[] args) {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
	}

	public boolean iniciarSesion(UsuarioDTO u) throws RemoteException {
		return rsl.getAutentificacionService().iniciarSesion(u.getEmail(), u.getPassword(),
				u.getAutorizationKind());
	}

	public void registrarUsuario() throws RemoteException {
		rsl.getAutentificacionService().registrarUsuario();
	}

}
