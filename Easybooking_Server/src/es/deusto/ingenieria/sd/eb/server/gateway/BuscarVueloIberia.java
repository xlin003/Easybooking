package es.deusto.ingenieria.sd.eb.server.gateway;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.dto.VueloDTO;

public class BuscarVueloIberia implements IAirlineGateway {
	private List<VueloDTO> flightList = new ArrayList<VueloDTO>();


	public BuscarVueloIberia() {
		
	}

	@SuppressWarnings("unchecked")
	public List<VueloDTO> buscarVuelo(String flightArgs) {
		String[] arrayflightArgs = flightArgs.split("#");

		// for (int i = 0; i < arrayflightArgs.length; i++) {
		// System.out.println(arrayflightArgs[i] + "<><><><>" + arrayflightArgs.length);
		// }

		try (Socket socket = new Socket(arrayflightArgs[4], Integer.parseInt(arrayflightArgs[5]));
				// Streams to send and receive information are created from the Socket
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

			out.writeUTF(flightArgs);
			System.out.println(" - EBSocketClient: Search flights to '" + socket.getInetAddress().getHostAddress() + ":"
					+ socket.getPort());

			Object data;
			data = in.readObject();
			flightList = (ArrayList<VueloDTO>) data;
			System.out.println(" - EBSocketClient: Received data from '" + socket.getInetAddress().getHostAddress()
					+ ":" + socket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# EBSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# EBSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# EBSocketClient: IO error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("# EBSocketClient: ClassNotFoundException error: " + e.getMessage());
		}

		return flightList;
	}

}
