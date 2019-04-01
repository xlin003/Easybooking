package autentificacion.server;

import java.rmi.Naming;

import autentificacion.server.remote.AutentificacionManager;
import autentificacion.server.remote.IAutentificacionManager;


public class AutentificacionServer {
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IAutentificacionManager server = new AutentificacionManager();
			Naming.rebind(name, server);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
