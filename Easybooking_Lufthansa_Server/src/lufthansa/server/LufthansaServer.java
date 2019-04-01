package lufthansa.server;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import lufthansa.server.remote.ILufthansaManager;
import lufthansa.server.remote.LufthansaManager;

public class LufthansaServer {

	public static void main(String[] args) {
		
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			ILufthansaManager server = new LufthansaManager();
			Naming.rebind(name, server);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
