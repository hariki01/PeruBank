package bastanteo;

public class Representante {

	private String codigo;
	private String nombres;
	private String apellidos;
	private String tipodoc;
	private String ndoc;
	private String cargo;
	private String grupo;
	private String codcli;
	private String codusua;

	public Representante(String codigo, String nombres, String apellidos,
			String tipodoc, String ndoc, String cargo, String grupo,
			String codcli, String codusua) {
		super(); // el super siempre va en primer lugar
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipodoc = tipodoc;
		this.ndoc = ndoc;
		this.cargo = cargo;
		this.grupo = grupo;
		this.codcli = codcli;
		this.codusua = codusua;

	}

	public String getCodigo() {

		return codigo;
	}

	public String getNombres() {

		return nombres;
	}

	public String getApellidos() {

		return apellidos;
	}

	public String getTipodoc() {

		return tipodoc;
	}

	public String getNdoc() {

		return ndoc;
	}

	public String getCargo() {

		return cargo;
	}

	public String getGrupo() {

		return grupo;
	}

	public String getCodcli() {

		return codcli;
	}

	public String getCodusua() {

		return codusua;
	}

}
