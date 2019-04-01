package es.deusto.ingenieria.sd.eb.server.data.dto;

import java.io.Serializable;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

@SuppressWarnings("rawtypes")
public class VueloDTO implements ListModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numSeatsLeft;
	private String airline;
	private String oriCity;
	private String destCity;
	private String date;
	private AeropuertoDTO airport;

	public VueloDTO(String oriCity, String destCity, String date, int numSeatsLeft,
			String airline) {
		super();
		this.oriCity = oriCity;
		this.destCity = destCity;
		this.date = date;
		this.numSeatsLeft = numSeatsLeft;
		this.airline = airline;
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

	AeropuertoDTO getAirport() {
		return airport;
	}

	public void setAirport(AeropuertoDTO airport) {
		this.airport = airport;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
