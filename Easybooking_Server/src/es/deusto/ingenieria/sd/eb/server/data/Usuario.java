package es.deusto.ingenieria.sd.eb.server.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.ingenieria.sd.eb.server.data.Reserva;

@PersistenceCapable
public class Usuario {

	private String email;
	private String surname;
	private String name;
	private String password;
	private String autorizationKind;

	@Persistent(mappedBy="user", dependentElement="true")
	@Join
	private List<Reserva> bookingList = new ArrayList<Reserva>();

	public Usuario(String surname, String name, String email, String password,
			String autorizationKind) {
		super();
		this.email = email;
		this.surname = surname;
		this.name = name;
		this.password = password;
		this.autorizationKind = autorizationKind;
	}

	public void addBooking(Reserva booking) {
		bookingList.add(booking);
	}
	
	public void removeBoobking(Reserva booking) {
		bookingList.remove(booking);
	}

	
	public String getSurname() {
		return surname;
	}

	public List<Reserva> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Reserva> bookingList) {
		this.bookingList = bookingList;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutorizationKind() {
		return autorizationKind;
	}

	public void setAutorizationKind(String autorizationKind) {
		this.autorizationKind = autorizationKind;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
