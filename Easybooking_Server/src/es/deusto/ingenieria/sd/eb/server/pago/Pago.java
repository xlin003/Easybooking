package es.deusto.ingenieria.sd.eb.server.pago;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.ingenieria.sd.eb.server.data.Reserva;

@PersistenceCapable
public class Pago {

	@PrimaryKey
	private String codPago;
	private String hora;
	private String fecha;
	private Reserva reserva;
	private String tipoPago;

	public Pago(String codPago, String hora, String fecha, String tipoPago) {
		super();
		this.codPago = codPago;
		this.hora = hora;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getCodPago() {
		return codPago;
	}

	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}

}
