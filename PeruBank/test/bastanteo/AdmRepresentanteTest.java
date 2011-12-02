package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmRepresentanteTest {

	public AdmClientes registrarVariosClientes() throws ClienteException {
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		AdmClientes admcliente = new AdmClientes();

		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// 2do cliente
		ruc = "34509863021";
		codigo = "CL002";
		razonSocial = "Infor Global Solutions";
		fechaInicio = "02/06/2010";
		tipoEmpresa = "SAC";
		empleados = 30;
		
		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		return admcliente;

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante() throws ClienteException {

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


		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		
		AdmRepresentantes admrep=new AdmRepresentantes();
		admrep.registrarRepresentante(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		assertEquals(codcli,"CL002");
		assertNotNull(admrep);
		

		

	}
	
	@Test(expected=ClienteException.class)
	public void IngresoDatosRepClienteInexistente() throws ClienteException {

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


		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		
		AdmRepresentantes admrep=new AdmRepresentantes();
		admrep.registrarRepresentante(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		assertEquals(codcli,"CL002");
		assertNotNull(admrep);
		
	
		

	}
	
	@Test(expected=ClienteException.class)
	public void IngresoDatosVaciosRepresentante() throws ClienteException {

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


		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		
		AdmRepresentantes admrep=new AdmRepresentantes();
		admrep.registrarRepresentante(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		assertEquals(codcli,"CL002");
		assertNotNull(admrep);
		
	
		

	}
	
	@Test(expected=ClienteException.class)
	public void IngresoRepresentanteDuplicado() throws ClienteException {
         //Primer representante
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

		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		
		AdmRepresentantes admrep=new AdmRepresentantes();
		admrep.registrarRepresentante(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		admrep.registrarRepresentante(codigo,nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		assertEquals(codcli,"CL002");
		assertNotNull(admrep);
		
		
		

	}


}
