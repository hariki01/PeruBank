package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PoderTest {
	
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
	public void clienteDeberiaCrearseConDatosIniciales(){
		
		//Preparo el escenario	
		String codigo = "CHCO";
		String nombre = "Cobro de Cheques";
		String tipoProducto = "Activo";

		
		//Ejecuto el escenario
        Poderes poder = new Poderes(codigo, nombre, tipoProducto, codUsuario);
		
		//Verifico
        assertEquals(codigo, poder.getCodigo());
        assertEquals(nombre, poder.getNombre());
        assertEquals(tipoProducto, poder.getTipoProducto());
        assertEquals(codUsuario, poder.getCodusua());
       
	}

}
