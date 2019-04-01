package es.deusto.ingenieria.sd.eb.server.gateway;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;
import es.deusto.ingenieria.sd.eb.server.remote.RMIServiceLocator;

public class BuscarVueloLufthansa implements IAirlineGateway {

	private RMIServiceLocator rsl;

	public BuscarVueloLufthansa(String[] args) {
		super();
		rsl = new RMIServiceLocator();
		rsl.setService(args);
	}

	public List<VueloDTO> buscarVuelo(String flightArgs)
			throws NumberFormatException, RemoteException {
		String[] arrayflightArgs = flightArgs.split("#");
		return rsl.getLufthansaService().buscarVuelo(arrayflightArgs[0], arrayflightArgs[1],
				arrayflightArgs[2], Integer.parseInt(arrayflightArgs[3]));
	}

}
