package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdmBastanteoTest {

	AdmClientes admcli = new AdmClientes();
	AdmPoderes admpoder = new AdmPoderes();
	
	@Before
	public void LlenarDatos() throws ClienteException {

		AdmLlenarDatos adm = new AdmLlenarDatos();
		admcli = adm.registrarVariosClientes();
		admpoder = adm.registrarVariosPoderes();
	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoaSolafirma()
			throws ClienteException, ParseException {

		// preparamos el ejemplo
		// Cobro de Cheques
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "06/07/2012";

		String codigopoder = "";
		String codcli = "";

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();

			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc);
			assertEquals(codcli, "CL001");
			assertEquals(codigopoder, "CHCO");
			assertNotNull(admbastanteo);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void siIngresoDatosnoDeberiaRegistrarBastanteoaduplicadoSolafirma()
			throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();

			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc);
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc);

			assertEquals(codcli, "CL001");
			assertEquals(codigopoder, "CHCO");
			assertNotNull(admbastanteo);

		} catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoconCombinacion()
			throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "En Conjunto Con";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		try {
		
			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();
			AdmCombinacion admcom = new AdmCombinacion();

			grupo = "A";
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc);

			grupo = "B";
			admcom.registrarCombinacion(codigo, grupo, intervencion);

			grupo = "C";
			admcom.registrarCombinacion(codigo, grupo, intervencion);

			assertEquals(codcli, "CL001");
			assertEquals(codigopoder, "CHCO");
			assertNotNull(admbastanteo);
			assertNotNull(admcom);
		} catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void siIngresoDatosnoDeberiaRegistrarBastanteoconCombinacionaexistente()
			throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "En Conjunto Con";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();
			AdmCombinacion admcom = new AdmCombinacion();

			grupo = "A";
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc);

			grupo = "B";
			admcom.registrarCombinacion(codigo, grupo, intervencion);

			grupo = "C";
			admcom.registrarCombinacion(codigo, grupo, intervencion);

			grupo = "C";
		    admcom.registrarCombinacion(codigo, grupo, intervencion);

			assertEquals(codcli, "CL001");
			assertEquals(codigopoder, "CHCO");
			assertNotNull(admbastanteo);
			assertNotNull(admcom);
		} catch (ClienteException ex) {
			System.out.println(ex);
		}
	}

}
