package es.deusto.ingenieria.sd.eb.server.gateway;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public interface IAirlineGateway {
	
	public List<VueloDTO> buscarVuelo(String flightArgs)throws NumberFormatException, RemoteException;

}
