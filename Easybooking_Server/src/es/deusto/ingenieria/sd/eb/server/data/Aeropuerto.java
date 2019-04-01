package es.deusto.ingenieria.sd.eb.server.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Aeropuerto {

	private String codigoPostal;
	private String nombre;
	private String pais;
	private String ciudad;

	@Join
	private List<Vuelo> flightList = new ArrayList<Vuelo>();

	public Aeropuerto(String codigoPostal, String nombre, String ciudad, String pais) {
		super();
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Vuelo> getVuelos() {
		return flightList;

	}

	public int getNumberOfVuelo() {
		return flightList.size();
	}

	public void addVuelo(Vuelo vuelo) {
		flightList.add(vuelo);
	}

	public void removeVuelo(Vuelo vuelo) {
		flightList.remove(vuelo);
	}

}
