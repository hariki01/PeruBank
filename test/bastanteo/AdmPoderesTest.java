package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AdmPoderesTest {

	AdmUsuario admusuario = new AdmUsuario();

	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Registro de Poderes";
		String usuario = "jalcantara";
		String clave = "8520";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void LlenarDatos() throws ClienteException {
		admusuario = adm.registrarVariosUsuarios();
	}

	@Test
	public void siIngresoDatosDeberiaRegistrarPoderes() throws ClienteException {

		String codigo;
		String nombre;
		String tipoProducto;

		try {
			AdmPoderes admpoder = new AdmPoderes();

			codigo = "CHCO";
			nombre = "Cobro de Cheques";
			tipoProducto = "Activo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			codigo = "EFRE";
			nombre = "Retiro en Efectivo";
			tipoProducto = "Pasivo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			assertNotNull(admpoder);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void IngresoDatosPoderNulo() throws ClienteException {

		String codigo;
		String nombre;
		String tipoProducto;

		try {

			AdmPoderes admpoder = new AdmPoderes();

			codigo = "";
			nombre = "";
			tipoProducto = "Activo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			codigo = "EFRE";
			nombre = "Retiro en Efectivo";
			tipoProducto = "Pasivo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			assertNotNull(admpoder);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void IngresoDatosPoderDuplicado() throws ClienteException {

		String codigo;
		String nombre;
		String tipoProducto;

		try {

			AdmPoderes admpoder = new AdmPoderes();

			codigo = "CHCO";
			nombre = "Cobro de Cheques";
			tipoProducto = "Activo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			codigo = "CHCO";
			nombre = "Cobro de Cheques";
			tipoProducto = "Activo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto, codUsuario);

			assertNotNull(admpoder);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
