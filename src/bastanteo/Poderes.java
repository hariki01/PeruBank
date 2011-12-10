package bastanteo;

public class Poderes {

	private String codigo;
	private String nombre;
	private String tipoProducto;
	private String codusua;

	public Poderes(String codigo, String nombre, String tipoProducto,
			String codusua) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
		this.codusua = codusua;

	}

	public String getCodigo() {

		return codigo;
	}

	public String getNombre() {

		return nombre;
	}

	public String getTipoProducto() {

		return tipoProducto;
	}

	public String getCodusua() {

		return codusua;
	}

}
