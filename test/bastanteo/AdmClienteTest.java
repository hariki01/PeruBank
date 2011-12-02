package bastanteo;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class AdmClienteTest {

	@Test
	public void siIngresoDatosDeberiaRegistrarCliente() throws ClienteException {

		// preparamos el ejemplo
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		try {
			AdmClientes adm = new AdmClientes();

			// ejecutar
			adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
					tipoEmpresa, empleados);

			Cliente cliente = adm.buscarCliente(codigo);
			// Verificar
			assertNotNull(cliente);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}
	}

	@Test
	public void deberiaValidarDatosRequeridos() throws ClienteException {

		// preparar el ejemplo
		String ruc = "";
		String codigo = "";
		String razonSocial = "";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		try {

			AdmClientes adm = new AdmClientes();

			// ejecutar
			adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
					tipoEmpresa, empleados);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void noDeberiaRegistrarClientesDuplicados() throws ClienteException {
		// preparamos el escenario
		// Arrange
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		try {

			AdmClientes adm = new AdmClientes();

			// ejecutar
			// el primero se ejecuta sin problemas
			adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
					tipoEmpresa, empleados);

			// el segundo debe arrojar la exception
			adm.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
					tipoEmpresa, empleados);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
