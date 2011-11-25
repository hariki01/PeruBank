package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmBastanteos {
	
	List<Bastanteo> bastanteos;

	// 2do. En el constructor inicializo
	public AdmBastanteos() {
		bastanteos = new ArrayList<Bastanteo>();
	}

	public void registrarBastanteo(String codigo, String codigopoder, String grupo,
			String codcli, String intervencion, double importe, String fechavenc)throws ClienteException {

		validarDatos(codigo,codigopoder,grupo,codcli,intervencion,importe,fechavenc);
		validarBastanteo(codigopoder,grupo,codcli,intervencion);
    	// Guardando en poder grupo
		Bastanteo nuevoBastanteo = new Bastanteo(codigo,codigopoder,grupo,codcli,intervencion,importe,fechavenc);		
		
		// añaden a la lista
		bastanteos.add(nuevoBastanteo);

	}
	
	public void validarBastanteo(String codigopoder,String grupo,String codcli,String intervencion)throws ClienteException {
	       String codigo = "";
	       codigo =bastanteoexisteCodigo(codigopoder,grupo,codcli,intervencion);
			
	       
			if (codigo!=""  && intervencion=="A Sola Firma")
				throw new ClienteException("Bastanteo existente");
		}
		

	private void validarDatos(String codigo, String codigopoder, String grupo,
			String codcli, String intervencion, double importe,String fechavenc) throws ClienteException {
		String mensaje = "";
		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (codigopoder.equals(""))
			mensaje += "\nPoder no puede ser vacio";
		if (grupo.equals(""))
			mensaje += "\nGrupo de Bastanteo no puede ser vacio";
		if (codcli.equals(""))
			mensaje += "\nCliente no puede ser vacio";
		if (intervencion.equals(""))
			mensaje += "\nIntervencion no puede ser vacio";
		if (importe==0.00)
			mensaje += "\nImporte no puede ser 0";
		if (fechavenc.equals(""))
			mensaje += "\nFecha de Vencimiento no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	public String bastanteoexisteCodigo(String codigopoder,String grupo,String codcli,String intervencion) {
		String codigo = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigopoder().equals(codigopoder) &&
			    bastanteo.getGrupo().equals(grupo) &&
			    bastanteo.getCodCli().equals(codcli) &&
			    bastanteo.getIntervencion().equals(intervencion))
				codigo = bastanteo.getCodigo();
		return codigo;
	}


}
