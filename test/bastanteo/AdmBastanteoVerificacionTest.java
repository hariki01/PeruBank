package bastanteo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class AdmBastanteoVerificacionTest {

	AdmClientes admcli = new AdmClientes();
	AdmPoderes admpoder = new AdmPoderes();
	AdmRepresentantes admrep = new AdmRepresentantes();
	AdmBastanteos admbastanteo = new AdmBastanteos();

	@Before
	public void llenarDatos() throws ClienteException {
		AdmLlenarDatos adm = new AdmLlenarDatos();
		admcli = adm.registrarVariosClientes();
		admpoder = adm.registrarVariosPoderes();
		admrep = adm.registrarVariosRepresentantes();
		admbastanteo = adm.registrarVariosBastanteos();
	}

	@Test
	// 1. Representante tiene poder y cómo. public void
	public void VerificarBastanteoPoderYComo() throws ClienteException {

		String ruc = "12232720907";
		String ndoc = "89654023";//
		String nombrePoder = "Cobro de Cheques";
		String tipoProducto = "Activo";
		String codCli = "";
		String codRep = "";
		String codPoder = "";
		String codBast = "";
		String grupoRep = "";
		String grupoBastanteo = "";
		String intervencion = "";

		try {
			admcli.validarClienteRuc(ruc);
			codCli = admcli.clienteExisteRuc(ruc); // Representante
			admrep.validarRepresentanteNdoc(ndoc);
			codRep = admrep.representanteExisteNdoc(ndoc);
			admpoder.validarPoder(nombrePoder, tipoProducto);
			codPoder = admpoder.buscarcodigoPoder(nombrePoder, tipoProducto);

			grupoRep = admrep.representanteExisteGrupo(codRep);

			codBast = admbastanteo.bastanteoExisteCodigo(codCli, codPoder);

			grupoBastanteo = admbastanteo.bastanteoExisteGrupo(codBast);
			intervencion = admbastanteo.bastanteoExisteIntervencion(codBast);

			// validar con los valores de retorno
			String validar_intervencion = "A Sola Firma";

			admbastanteo.validarConsulta(grupoRep, intervencion,
					grupoBastanteo, validar_intervencion);

			assertEquals(grupoBastanteo, grupoRep);
			assertEquals(intervencion, validar_intervencion);

		} catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void VerificarBastanteoPodereYaVencio() throws ClienteException,
			ParseException {

		Calendar c = Calendar.getInstance();
		Calendar cc = Calendar.getInstance();

		String ruc = "12232720907";// Cliente - RUC
		String ndoc = "89654023";// Representante - Identificacion
		String nombrePoder = "Cobro de Cheques";// Poder - Nombre
		String tipoProducto = "Activo";// Poder Tipo

		String codCli = "";
		String codRep = "";
		String codPoder = "";
		String codBast = "";
		String grupoRep = "";
		String grupoBastanteo = "";
		String intervencion = "";
		String fechaVenc = "";
		Date fechaVencimiento;

		try {
			// Cliente
			admcli.validarClienteRuc(ruc);
			codCli = admcli.clienteExisteRuc(ruc);
			// Representante
			admrep.validarRepresentanteNdoc(ndoc);
			codRep = admrep.representanteExisteNdoc(ndoc);
			// Poder
			admpoder.validarPoder(nombrePoder, tipoProducto);
			codPoder = admpoder.buscarcodigoPoder(nombrePoder, tipoProducto);

			grupoRep = admrep.representanteExisteGrupo(codRep);

			codBast = admbastanteo.bastanteoExisteCodigo(codCli, codPoder);

			grupoBastanteo = admbastanteo.bastanteoExisteGrupo(codBast);
			intervencion = admbastanteo.bastanteoExisteIntervencion(codBast);

			// validar con los valores de retorno
			String validar_intervencion = "A Sola Firma";

			admbastanteo.validarConsulta(grupoRep, intervencion,
					grupoBastanteo, validar_intervencion);

			assertEquals(grupoBastanteo, grupoRep);
			assertEquals(intervencion, validar_intervencion);

			fechaVenc = admbastanteo.bastanteoExisteFecha(codBast);

			DateFormat formatter;
			Date date;
			String fechaactual;
			Date fecha;
			formatter = new SimpleDateFormat("dd/MM/yyyy");

			date = (Date) formatter.parse(fechaVenc);
			fechaactual = formatter.format(c.getTime());
			fecha = (Date) formatter.parse(fechaactual);

			boolean sw = false;

			admbastanteo.validarFecha(date, fecha);
			sw = admbastanteo.retornoFecha(date, fecha);

			assertTrue(sw);

		} catch (ClienteException ex) {
			System.out.println(ex);
		}

	}
}
