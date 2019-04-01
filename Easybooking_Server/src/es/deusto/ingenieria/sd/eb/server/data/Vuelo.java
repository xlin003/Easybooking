package es.deusto.ingenieria.sd.eb.server.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Vuelo {

	private int numSeatsLeft;
	private String airline;
	private String oriCity;
	private String destCity;
	private String date;
	private Aeropuerto airport;

	@Persistent(mappedBy = "flight", dependentElement = "true")
	@Join
	private List<Reserva> bookingList = new ArrayList<Reserva>();

	public Vuelo(String oriCity, String destCity, String date, int numSeatsLeft, String airline) {
		super();
		this.oriCity = oriCity;
		this.destCity = destCity;
		this.date = date;
		this.numSeatsLeft = numSeatsLeft;
		this.airline = airline;
	}

	public void addBooking(Reserva booking) {
		bookingList.add(booking);
	}

	public void removeBoobking(Reserva booking) {
		bookingList.remove(booking);
	}

	public List<Reserva> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Reserva> bookingList) {
		this.bookingList = bookingList;
	}

	public int getNumSeatsLeft() {
		return numSeatsLeft;
	}

	public void setNumSeatsLeft(int numSeatsLeft) {
		this.numSeatsLeft = numSeatsLeft;
	}

	public String getOriCity() {
		return oriCity;
	}

	public void setOriCity(String oriCity) {
		this.oriCity = oriCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	Aeropuerto getAirport() {
		return airport;
	}

	public void setAirport(Aeropuerto airport) {
		this.airport = airport;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

}
