package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmPoderesTest {

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

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

			codigo = "EFRE";
			nombre = "Retiro en Efectivo";
			tipoProducto = "Pasivo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

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

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

			codigo = "EFRE";
			nombre = "Retiro en Efectivo";
			tipoProducto = "Pasivo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

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

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

			codigo = "CHCO";
			nombre = "Cobro de Cheques";
			tipoProducto = "Activo";

			admpoder.registrarPoderes(codigo, nombre, tipoProducto);

			assertNotNull(admpoder);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
