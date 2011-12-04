package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmRepresentanteTest {

	AdmClientes admcli = new AdmClientes();

	
	public void LlamarClientes() throws ClienteException {

		AdmLlenarDatos adm = new AdmLlenarDatos();
		admcli = adm.registrarVariosClientes();
	}

	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante()
			throws ClienteException {

		try {

			LlamarClientes();

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
					ndoc, cargo, grupo, codcli);

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

			LlamarClientes();

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
					ndoc, cargo, grupo, codcli);

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

			LlamarClientes();

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
					ndoc, cargo, grupo, codcli);

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

			LlamarClientes();
            
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
					ndoc, cargo, grupo, codcli);
			admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc,
					ndoc, cargo, grupo, codcli);

			assertEquals(codcli, "CL002");
			assertNotNull(admrep);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
