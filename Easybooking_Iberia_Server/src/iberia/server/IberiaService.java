package iberia.server;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class IberiaService {

	private DataInputStream in;
	private ObjectOutputStream out;
	private Socket tcpSocket;
	private static String DELIMITER = "#";
	private List<VueloDTO> flightList = new ArrayList<VueloDTO>();

	private Random randnum;
	private String airline = "Iberia";

	public IberiaService(Socket socket) {
		super();
		randnum = new Random();
		randnum.setSeed(100);
		try {
			this.tcpSocket = socket;
			this.createFlightList();
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new ObjectOutputStream(socket.getOutputStream());
			this.runSocket();
		} catch (IOException e) {
			System.err.println("# IberiaAirlineService - TCPConnection IO error:" + e.getMessage());
		}

	}

	private void createFlightList() {
		for (int i = 0; i < 1000; i++) {
			// System.out.println(dateSetter() + " " + randBetween(0, 100));
			flightList.add(
					createFlight("Bilbao", "Madrid", dateSetter(), randBetween(0, 100), airline));
			flightList.add(
					createFlight("Bilbao", "London", dateSetter(), randBetween(0, 100), airline));
			flightList.add(
					createFlight("Bilbao", "Paris", dateSetter(), randBetween(0, 100), airline));
			flightList.add(
					createFlight("Barcelona", "Milan", dateSetter(), randBetween(0, 100), airline));
			flightList.add(
					createFlight("Bilbao", "Berlin", dateSetter(), randBetween(0, 100), airline));
			flightList.add(createFlight("Bilbao", "Frankfurt", dateSetter(), randBetween(0, 100),
					airline));
			flightList.add(
					createFlight("Barcelona", "Roma", dateSetter(), randBetween(0, 100), airline));
			flightList.add(
					createFlight("Bilbao", "Rabat", dateSetter(), randBetween(0, 100), airline));
		}
	}

	public void runSocket() {
		try {
			String data = this.in.readUTF();
			System.out.println("   - IberiaAirlineService - Received data from '"
					+ tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort()
					+ "' -> '" + data + "'");
			this.out.writeObject(this.buscarVuelo(data));
		} catch (EOFException e) {
			System.err.println(
					"   # IberiaAirlineService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println(
					"   # IberiaAirlineService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println(
						"   # IberiaAirlineService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}

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

	public List<VueloDTO> buscarVuelo(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, DELIMITER);
		List<VueloDTO> myFlights = new ArrayList<VueloDTO>();
		try {
			String originCity = tokenizer.nextToken();
			String destinationCity = tokenizer.nextToken();
			String date = tokenizer.nextToken();
			String numPassenger = tokenizer.nextToken();

			for (VueloDTO flight : flightList) {
				if (flight.getOriCity().equals(originCity)
						&& flight.getDestCity().equals(destinationCity)
						&& flight.getDate().equals(date)
						&& flight.getNumSeatsLeft() >= Integer.parseInt(numPassenger)) {
					myFlights.add(flight);
				}
			}
		} catch (Exception e) {
			System.err.println("   # IberiaAirlineService - IberiaAirline error:" + e.getMessage());
			myFlights = null;
		}

		return myFlights;

	}

}
