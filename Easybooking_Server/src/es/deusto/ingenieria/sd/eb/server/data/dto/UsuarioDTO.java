package es.deusto.ingenieria.sd.eb.server.data.dto;

import java.io.Serializable;
import java.util.List;

import es.deusto.ingenieria.sd.eb.server.data.Reserva;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String surname;
	private String name;
	private String password;
	private String autorizationKind;

	public UsuarioDTO(String surname, String name, String email, String password,
			String autorizationKind) {
		super();
		this.email = email;
		this.surname = surname;
		this.name = name;
		this.password = password;
		this.autorizationKind = autorizationKind;
	}

	public String getSurname() {
		return surname;
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
