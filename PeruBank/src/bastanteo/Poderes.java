package bastanteo;

public class Poderes {
	
	private String codigo;
	private String nombre;
	private String tipoProducto;
	
	public Poderes (String codigo, String nombre, String tipoProducto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipoProducto = tipoProducto;
		
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

}
