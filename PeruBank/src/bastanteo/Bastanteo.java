package bastanteo;



public class Bastanteo {

	private String codigo;
	private String codigopoder;
	private String grupo;
	private String codcli;
	private String intervencion;
	double importe;
	private String fechavenc;
	
	

	public Bastanteo(String codigo, String codigopoder, String grupo,
			String codcli, String intervencion, double importe, String fechavenc) {
		super(); // el super siempre va en primer lugar
		this.codigo = codigo;
		this.codigopoder = codigopoder;
		this.grupo = grupo;
		this.codcli = codcli;
		this.intervencion = intervencion;
		this.importe = importe;
		this.fechavenc = fechavenc;
		
		
	}

	public String getCodigo() {

		return codigo;
	}

	public String getCodigopoder() {

		return codigopoder;
	}

	public String getGrupo() {

		return grupo;
	}

	public String getCodCli() {

		return codcli;
	}

	public String getIntervencion() {

		return intervencion;
	}

	public double getImporte() {

		return importe;
	}

	public String getFechaVenc() {

		return fechavenc;
	}

	

}
