package es.deusto.ingenieria.sd.eb.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;

import es.deusto.ingenieria.sd.eb.server.data.Vuelo;

public class AeropuertoDTO {

	private String codigoPostal;
	private String nombre;
	private String pais;
	private String ciudad;

	@Join
	private List<Vuelo> listVuelo = new ArrayList<Vuelo>();

	public AeropuertoDTO(String codigoPostal, String nombre, String ciudad, String pais) {
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
		return listVuelo;

	}

	public int getNumberOfVuelo() {
		return listVuelo.size();
	}

	public void addVuelo(Vuelo vuelo) {
		listVuelo.add(vuelo);
	}

	public void removeVuelo(Vuelo vuelo) {
		listVuelo.remove(vuelo);
	}

}
