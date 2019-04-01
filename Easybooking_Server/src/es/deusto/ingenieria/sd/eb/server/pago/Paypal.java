package es.deusto.ingenieria.sd.eb.server.pago;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Paypal extends Pago {

	private String email;
	private Pago pago;

	public Paypal(String codPago, String hora, String fecha, String tipoPago, String email, Pago pago) {
		super(codPago, hora, fecha, tipoPago);
		this.email = email;
		this.pago = pago;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}
