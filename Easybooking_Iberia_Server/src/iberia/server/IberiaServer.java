package iberia.server;

import java.io.IOException;
import java.net.ServerSocket;


public class IberiaServer {
	private static int numClients = 0;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println(" # Usage: IberiaAirlineServer [PORT]");
			System.exit(1);
		}

		// args[1] = Server socket port
		int serverPort = Integer.parseInt(args[0]);

		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - IberiaAirlineServer: Waiting for connections '"
			        + tcpServerSocket.getInetAddress().getHostAddress() + ":"
			        + tcpServerSocket.getLocalPort() + "' ...");

			while (true) {
				new IberiaService(tcpServerSocket.accept());
				System.out.println(
				        " - IberiaAirlineServer: New client connection accepted. Client number: "
				                + ++numClients);
			}
		} catch (IOException e) {
			System.err.println("# IberiaAirlineServer: IO error:" + e.getMessage());
		}
	}
}
