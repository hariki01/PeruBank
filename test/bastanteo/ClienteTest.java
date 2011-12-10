package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	AdmUsuario admusuario = new AdmUsuario();

	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Registro de Clientes";
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
	public void clienteDeberiaCrearseConDatosIniciales(){
		
		//Preparo el escenario	
        String ruc = "20565455656";
        String codigo = "CL001";
        String razonSocial = "ACME Solutions";
        String fechaInicio = "01/01/2010";
        String tipoEmpresa = "SAC";
        int empleados = 10;
        
		//Ejecuto el escenario
        Cliente cliente = new Cliente(codigo, ruc,
        		razonSocial, fechaInicio, tipoEmpresa, empleados,codUsuario);
		
		//Verifico
        assertEquals(codigo, cliente.getCodigo());
        assertEquals(ruc, cliente.getRuc());
        assertEquals(razonSocial, cliente.getRazonSocial());
        assertEquals(fechaInicio, cliente.getFechaInicio());
        assertEquals(tipoEmpresa, cliente.getTipoEmpresa());
        assertEquals(empleados, cliente.getEmpleados());
        assertEquals(codUsuario, cliente.getCodusua());
        
		
	}
}
