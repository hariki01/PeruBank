package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmRepresentantes {

	List<Representante> representantes;

	// 2do. En el constructor inicializo
	public AdmRepresentantes() {
		representantes = new ArrayList<Representante>();
	}

	public void registrarRepresentante(String codigo,String nombres, String apellidos,
			String tipodoc, String ndoc, String cargo, String grupo,String codcli)
			throws ClienteException {

		// validar datos
		validarDatosrep(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo,codcli);
		
		//validar representante
		validarDuplicado(tipodoc,ndoc);
		

		Representante rep = new Representante(codigo,nombres, apellidos, tipodoc,
				ndoc, cargo, grupo,codcli);

		// agregando los valores al areglo

		representantes.add(rep);
		
	//	throw new ClienteException("Representante registrado con exito");
	}

	private void validarDuplicado(String tipodoc, String ndoc)
			throws ClienteException {

		if (representanteExiste(tipodoc, ndoc))
			throw new ClienteException("Representante Existente");
	}

	private boolean representanteExiste(String tipodoc, String ndoc) {
		boolean existe = false;

		// and && , || or
		for (Representante representante : representantes)
			if (representante.getTipodoc().equals(tipodoc) && 
					representante.getNdoc().equals(ndoc))     
				existe = true;
		return existe;
	}

	private void validarDatosrep(String codigo,String nombres, String apellidos,
			String tipodoc, String ndoc, String cargo, String grupo,String codcli)
			throws ClienteException {

		String mensaje = "";

		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (nombres.equals(""))
			mensaje += "\nNombre no puede ser vacio";
		if (apellidos.equals(""))
			mensaje += "\nApellidos no puede ser vacio";
		if (tipodoc.equals(""))
			mensaje += "\nTipo de documento no puede ser vacio";
		if (ndoc.equals(""))
			mensaje += "\nNumero de documento no puede ser vacio";
		if (cargo.equals(""))
			mensaje += "\ncargo El cargo en la empresa no puede ser vacio";
		if (grupo.equals(""))
			mensaje += "\ngrupo El grupo de bastanteo no puede ser vacio";
		if (codcli.equals(""))
			mensaje += "\ncodcli El Cliente no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	public Representante buscarRepresentante(String tipodoc,String ndoc) {
		for (Representante representante : representantes)
			if (representante.getTipodoc().equals(tipodoc) && 
				representante.getNdoc().equals(ndoc))     
				return representante;
		return null;
	}
	
	public String representanteExisteNdoc(String ndoc) {
		String codigo = "";

		// and && , || or
		for (Representante representante : representantes)
			if (representante.getNdoc().equals(ndoc))
				codigo = representante.getCodigo();
		return codigo;
	}
	
	public void validarRepresentanteNdoc(String ndoc) throws ClienteException {
	       String codigo = "";
	       codigo =representanteExisteNdoc(ndoc);
			
			if (codigo=="")
				throw new ClienteException("Documento del Representante Invalido...");
		}
	
	public String representanteExisteGrupo(String codigo) {
		String grupo = "";

		// and && , || or
		for (Representante representante : representantes)
			if (representante.getCodigo().equals(codigo))
				grupo = representante.getGrupo();
		return grupo;
	}

}
