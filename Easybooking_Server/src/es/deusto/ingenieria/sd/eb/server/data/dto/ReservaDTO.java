package es.deusto.ingenieria.sd.eb.server.data.dto;

import java.io.Serializable;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.ingenieria.sd.eb.server.data.Usuario;
import es.deusto.ingenieria.sd.eb.server.data.Vuelo;
import es.deusto.ingenieria.sd.eb.server.pago.Pago;

public class ReservaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int seats;
	private UsuarioDTO user;
	private VueloDTO flight;
	private double cost;
	private long id;
	// private Pago payment;

	public ReservaDTO(long id, UsuarioDTO user, VueloDTO flight, int seats) {
		super();
		this.id = id;
		this.user = user;
		this.flight = flight;
		this.seats = seats;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUserDTO(UsuarioDTO user) {
		this.user = user;
	}

	public VueloDTO getFlight() {
		return flight;
	}

	public void setFlight(VueloDTO flight) {
		this.flight = flight;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	// public Pago getPayment() {
	// return payment;
	// }
	//
	// public void setPayment(Pago payment) {
	// this.payment = payment;
	// }

}
