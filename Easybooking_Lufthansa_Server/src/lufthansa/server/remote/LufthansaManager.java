package lufthansa.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class LufthansaManager extends UnicastRemoteObject implements ILufthansaManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<VueloDTO> flightList = new ArrayList<VueloDTO>();

	Random randnum;

	private VueloDTO createFlight(String ciudadOrigen, String ciudadDestino, String fecha,
			int plazaRestante, String airline) {
		return new VueloDTO(ciudadOrigen, ciudadDestino, fecha, plazaRestante, airline);
	}

	public int random(int i) {
		return randnum.nextInt(i);
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public String dateSetter() {
		String d = null;
		String m = null;
		randnum = new Random();
		randnum.setSeed(100);
		int year = randBetween(2018, 2018);
		int month = randBetween(1, 12);
		int day = randBetween(1, 31);
		if (day <= 9) {
			d = String.valueOf(day);
			d = 0 + d;
		} else {
			d = String.valueOf(day);
		}
		if (month <= 9) {
			m = String.valueOf(month);
			m = 0 + m;
		} else {
			m = String.valueOf(month);
		}
		String date = new String(d + "-" + m + "-" + year);
		return date;
	}

	public LufthansaManager() throws RemoteException {
		super();
		randnum = new Random();
		randnum.setSeed(100);

		for (int i = 0; i < 1000; i++) {
			// System.out.println(dateSetter()+" "+randBetween(0,100));
			flightList.add(createFlight("Bilbao", "Madrid", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Bilbao", "London", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Bilbao", "Paris", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Barcelona", "Milan", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Bilbao", "Berlin", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Bilbao", "Frankfurt", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Barcelona", "Roma", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
			flightList.add(createFlight("Bilbao", "Rabat", dateSetter(), randBetween(0, 100),
					"Lufthansa"));
		}
	}

	public List<VueloDTO> buscarVuelo(String nomCiudadOrigen, String nomCiudadDestino, String fecha,
			int numPasajeros) throws RemoteException {
		List<VueloDTO> myFlights = new ArrayList<VueloDTO>();
		for (VueloDTO flight : flightList) {
			if (flight.getOriCity().equals(nomCiudadOrigen)
					&& flight.getDestCity().equals(nomCiudadDestino)
					&& flight.getDate().equals(fecha) && flight.getNumSeatsLeft() >= numPasajeros) {
				myFlights.add(flight);
			}
		}
		return myFlights;
	}

}
