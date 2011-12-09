package bastanteo;



public class Bastanteo {

	private String codigo;
	private String codigopoder;
	private String grupo;
	private String codcli;
	private String intervencion;
	private double importe;
	private String fechavenc;
	private String codusu;
	

	public Bastanteo(String codigo, String codigopoder, String grupo,
			String codcli, String intervencion, double importe, String fechavenc,String codusu) {
		super(); // el super siempre va en primer lugar
		this.codigo = codigo;
		this.codigopoder = codigopoder;
		this.grupo = grupo;
		this.codcli = codcli;
		this.intervencion = intervencion;
		this.importe = importe;
		this.fechavenc = fechavenc;
		this.codusu = codusu;
		
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

	public String getCodusu() {

		return codusu;
	}	

}
