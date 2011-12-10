package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AdmRepresentanteTest {

	AdmClientes admcli = new AdmClientes();
	AdmUsuario admusuario = new AdmUsuario();
	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Registro de Representantes";
		String usuario = "hbruno";
		String clave = "2210";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void LlenarDatos() throws ClienteException {

		admusuario = adm.registrarVariosUsuarios();
		admcli = adm.registrarVariosClientes();

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante()
			throws ClienteException {

		try {

			// preparamos el ejemplo
			String codigo = "REP001";
			String nombres = "Luis Carlos";
			String apellidos = "Rodriguez Rojas";
			String tipodoc = "Dni";
			String ndoc = "89654023";
			String cargo = "Gerente";
			String grupo = "A";
			String nombrecli = "Infor Global Solutions";
			String codcli = "";

			codcli = admcli.clienteexisteCodigo(nombrecli);
			admcli.validarCliente(nombrecli);

			AdmRepresentantes admrep = new AdmRepresentantes();
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli, codUsuario);

			assertEquals(codcli, "CL002");
			assertNotNull(admrep);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void IngresoDatosRepClienteInexistente() throws ClienteException {

		try {

			// preparamos el ejemplo
			String codigo = "REP001";
			String nombres = "Luis Carlos";
			String apellidos = "Rodriguez Rojas";
			String tipodoc = "Dni";
			String ndoc = "89654023";
			String cargo = "Gerente";
			String grupo = "A";
			String nombrecli = "ABC S.A.C";
			String codcli = "";

			codcli = admcli.clienteexisteCodigo(nombrecli);
			admcli.validarCliente(nombrecli);

			AdmRepresentantes admrep = new AdmRepresentantes();
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli, codUsuario);

			assertEquals(codcli, "CL002");
			assertNotNull(admrep);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void IngresoDatosVaciosRepresentante() throws ClienteException {

		try {

			// preparamos el ejemplo
			String codigo = "REP001";
			String nombres = "Luis Carlos";
			String apellidos = "Rodriguez Rojas";
			String tipodoc = "Dni";
			String ndoc = "89654023";
			String cargo = "Gerente";
			String grupo = "A";
			String nombrecli = "ABC S.A.C";
			String codcli = "";

			codcli = admcli.clienteexisteCodigo(nombrecli);
			admcli.validarCliente(nombrecli);

			AdmRepresentantes admrep = new AdmRepresentantes();
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli, codUsuario);

			assertEquals(codcli, "CL002");
			assertNotNull(admrep);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void IngresoRepresentanteDuplicado() throws ClienteException {

		try {

			// Primer representante
			// preparamos el ejemplo
			String codigo = "REP001";
			String nombres = "Luis Carlos";
			String apellidos = "Rodriguez Rojas";
			String tipodoc = "Dni";
			String ndoc = "89654023";
			String cargo = "Gerente";
			String grupo = "A";
			String nombrecli = "Infor Global Solutions";
			String codcli = "";

			codcli = admcli.clienteexisteCodigo(nombrecli);
			admcli.validarCliente(nombrecli);

			AdmRepresentantes admrep = new AdmRepresentantes();
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli, codUsuario);
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli, codUsuario);

			assertEquals(codcli, "CL002");
			assertNotNull(admrep);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
