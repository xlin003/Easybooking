package lufthansa.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public interface ILufthansaManager extends Remote {

	public List<VueloDTO> buscarVuelo(String nomCiudadOrigen, String nomCiudadDestino, String fecha, int numPasajeros)
			throws RemoteException;

}
