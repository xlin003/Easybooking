package es.deusto.ingenieria.sd.eb.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.eb.server.remote.EasyBookingManager;
import es.deusto.ingenieria.sd.eb.server.remote.IEasyBookingManager;

public class EasybookingServer {
	
	public static void main(String[] args) {
		if (args.length != 10) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IEasyBookingManager EBServer = new EasyBookingManager(args);
			Naming.rebind(name, EBServer);
			System.out.println("- EasyBookingManager '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
