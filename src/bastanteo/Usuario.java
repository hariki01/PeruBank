package bastanteo;

public class Usuario {

	private String codusu;
	private String nombre;
	private String documento;
	private String email;
	private String user;
	private String clave;
	private String rol;

	public Usuario(String codusu,String nombre, String documento, String email, String user,
			String clave, String rol) {
		// TODO Auto-generated constructor stub
		super();
		this.codusu = codusu; 
		this.nombre = nombre;
		this.documento = documento;
		this.email = email;
		this.user = user;
		this.clave = clave;
		this.rol = rol;
	}
	
	public String getCodusu() {
		return codusu;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getUser() {
		return user;
	}

	public String getClave() {
		return clave;
	}

	public String getRol() {
		return rol;
	}

}
