package es.deusto.ingenieria.sd.eb.server.pago;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class TarjetaDeCredito extends Pago {

	private int numeroTarjeta;
	private int ccv;
	private String titular;
	private String fechaCaducidad;
	private Pago pago;

	public TarjetaDeCredito(String codPago, String hora, String fecha, String tipoPago, int numeroTarjeta, int ccv,
			String titular, String fechaCaducidad, Pago pago) {
		super(codPago, hora, fecha, tipoPago);
		this.numeroTarjeta = numeroTarjeta;
		this.ccv = ccv;
		this.titular = titular;
		this.fechaCaducidad = fechaCaducidad;
		this.pago = pago;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}
