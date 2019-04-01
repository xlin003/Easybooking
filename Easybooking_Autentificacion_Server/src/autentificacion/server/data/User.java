package autentificacion.server.data;


public class User {
	
	private String apellido;
	private String nombre;
	private String email;
	private String password;
	private String tipoAutorizacion;
	
	

	public User(String apellido, String nombre, String email, String password, String tipoAutorizacion) {
		super();
		this.email = email;
		this.apellido = apellido;
		this.nombre = nombre;
		this.password = password;
		this.tipoAutorizacion = tipoAutorizacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoAutorizacion() {
		return tipoAutorizacion;
	}

	public void setTipoAutorizacion(String tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}
}
