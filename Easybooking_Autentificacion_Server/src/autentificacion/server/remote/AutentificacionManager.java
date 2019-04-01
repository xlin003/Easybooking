package autentificacion.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import autentificacion.server.data.User;

public class AutentificacionManager extends UnicastRemoteObject implements IAutentificacionManager {

	private List<User> listUser = new ArrayList<User>();
	private static final long serialVersionUID = 1L;
	private String name;
	private User user1 = new User("Lin", "Xian", "xian.lin@opendeusto.es", "000", "Google");
	private User user2 = new User("Anguiano", "Marta", "marta.anguiano@opendeusto.es", "111", "Facebook");
	private User user3 = new User("Ugarte", "Garbine", "garbine.ugarte@opendeusto.es", "222", "Facebook");

	public AutentificacionManager() throws RemoteException {
		super();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
	}

	public boolean iniciarSesion(String mail, String password, String choice) {
		boolean b = false;
		for (User user : listUser) {
			if (mail.equals(user.getEmail()) && password.equals(user.getPassword())
					&& choice.equals(user.getTipoAutorizacion())) {
				name = user.getNombre();
				b = true;
			}
		}
		return b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void registrarUsuario() {
		System.out.println("hello");
	}

}
