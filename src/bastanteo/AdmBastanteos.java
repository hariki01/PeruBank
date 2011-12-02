package bastanteo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AdmBastanteos {

	List<Bastanteo> bastanteos;

	// 2do. En el constructor inicializo
	public AdmBastanteos() {
		bastanteos = new ArrayList<Bastanteo>();
	}

	public void registrarBastanteo(String codigo, String codigopoder,
			String grupo, String codcli, String intervencion, double importe,
			String fechavenc) throws ClienteException {

		validarDatos(codigo, codigopoder, grupo, codcli, intervencion, importe,
				fechavenc);
		validarBastanteo(codigopoder, grupo, codcli, intervencion);
		// Guardando en poder grupo
		Bastanteo nuevoBastanteo = new Bastanteo(codigo, codigopoder, grupo,
				codcli, intervencion, importe, fechavenc);

		// añaden a la lista
		bastanteos.add(nuevoBastanteo);

	}

	public void validarBastanteo(String codigopoder, String grupo,
			String codcli, String intervencion) throws ClienteException {
		String codigo = "";
		codigo = bastanteoexisteCodigo(codigopoder, grupo, codcli, intervencion);

		if (codigo != "" && intervencion == "A Sola Firma")
			throw new ClienteException("Bastanteo existente");
	}

	public void validarFecha(Date fecha1, Date fecha2) throws ClienteException {
		
		if(fecha1.before(fecha2))
           throw new ClienteException("La Fecha de Vencimiento ya expiro");
	}
	
	public boolean retornoFecha(Date fecha1, Date fecha2) {
		boolean estado = false;
		
		if(fecha1.before(fecha2))
           estado = true;
		return estado;
	}
	
	private void validarDatos(String codigo, String codigopoder, String grupo,
			String codcli, String intervencion, double importe, String fechavenc)
			throws ClienteException {
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
		if (importe == 0.00)
			mensaje += "\nImporte no puede ser 0";
		if (fechavenc.equals(""))
			mensaje += "\nFecha de Vencimiento no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	public String bastanteoexisteCodigo(String codigopoder, String grupo,
			String codcli, String intervencion) {
		String codigo = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigopoder().equals(codigopoder)
					&& bastanteo.getGrupo().equals(grupo)
					&& bastanteo.getCodCli().equals(codcli)
					&& bastanteo.getIntervencion().equals(intervencion))
				codigo = bastanteo.getCodigo();
		return codigo;
	}

	public String bastanteoExisteCodigo(String codigoCliente, String codigoPoder) {
		String codigo = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodCli().equals(codigoCliente)
					&& bastanteo.getCodigopoder().equals(codigoPoder))
				codigo = bastanteo.getCodigo();
		return codigo;
	}

	public String bastanteoExisteGrupo(String codigoBastanteo) {
		String grupo = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigo().equals(codigoBastanteo))
				grupo = bastanteo.getGrupo();
		return grupo;
	}

	public String bastanteoExisteIntervencion(String codigoBastanteo) {
		String intervencion = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigo().equals(codigoBastanteo))
				intervencion = bastanteo.getIntervencion();
		return intervencion;
	}
	
	public String bastanteoExisteFecha(String codigoBastanteo) {
		String fechaVenc = "";

		// and && , || or
		for (Bastanteo bastanteo : bastanteos)
			if (bastanteo.getCodigo().equals(codigoBastanteo))
				fechaVenc = bastanteo.getFechaVenc();
		return fechaVenc;
	}

	public void validarConsulta(String grupo1, String Intervencion1,
			String grupo2, String Intervencion2) throws ClienteException {
		String mensaje = "";

		if (grupo1 != grupo2) {
			mensaje += "El representante no puede realizar este Poder";
			throw new ClienteException(mensaje);
		}
		if (Intervencion1 != Intervencion2) {
			mensaje += "El representante no puede realizar este Poder";
			throw new ClienteException(mensaje);
		}
	}

}
