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
	AdmUsuario admusuario = new AdmUsuario();

	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Registro de Bastanteo";
		String usuario = "hbruno";
		String clave = "2210";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void LlenarDatos() throws ClienteException {

		admcli = adm.registrarVariosClientes();
		admpoder = adm.registrarVariosPoderes();
		admusuario = adm.registrarVariosUsuarios();

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoaSolafirma()
			throws ClienteException, ParseException {

		// preparamos el ejemplo
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

		// LlenarDatos();

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();

			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc, codUsuario);
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
		// LlenarDatos();

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();

			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc, codUsuario);
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc, codUsuario);

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

		// LlenarDatos();

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();
			AdmCombinacion admcom = new AdmCombinacion();

			grupo = "A";
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc, codUsuario);

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

		// LlenarDatos();

		try {

			admcli.validarCliente(nombrecli);
			codcli = admcli.clienteexisteCodigo(nombrecli);

			admpoder.validarPoder(nombrepoder, tiposervicio);
			codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);

			AdmBastanteos admbastanteo = new AdmBastanteos();
			AdmCombinacion admcom = new AdmCombinacion();

			grupo = "A";
			admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
					intervencion, importe, fechavenc, codUsuario);

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
