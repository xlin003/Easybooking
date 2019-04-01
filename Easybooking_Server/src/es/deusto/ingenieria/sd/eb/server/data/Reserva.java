package es.deusto.ingenieria.sd.eb.server.data;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {

	@PrimaryKey
	@Column(name = "ID", jdbcType = "BIGINT")
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long id = null;
	private int seats;
	private Vuelo flight;
	private double cost;
	// private Pago payment;
	private Usuario user;

	public Reserva(long id, Usuario user, Vuelo flight, int seats) {
		super();
		this.id = id;
		this.user = user;
		this.flight = flight;
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Vuelo getFlight() {
		return flight;
	}

	public void setFlight(Vuelo flight) {
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