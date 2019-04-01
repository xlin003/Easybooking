package es.deusto.ingenieria.sd.eb.server.gateway;


import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;

public interface IGatewayAutentificacion {

	public boolean iniciarSesion(UsuarioDTO u) throws RemoteException;
	
	public void registrarUsuario() throws RemoteException;
}
