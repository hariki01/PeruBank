package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AdmUsuarioTest {
	
	AdmUsuario admusuario = new AdmUsuario();

	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

	String opcion = "Registro de Usuarios";
	String usuario = "hespiritu";
	String clave = "abc";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void LlenarDatos() throws ClienteException {
		admusuario = adm.registrarVariosUsuarios();
	}

	@Test
	public void ejecutarLogoncorrectamente() throws ClienteException {

		// [1] Datos de ejemplo para Usuario
		String user = "hespiritu";
		String clave = "abc";
        String opcion_ingreso = "Registro de Bastanteo";
	

		try {
		
			// [03] Ejecutamos el Logon de usuario
			admusuario.logon(user, clave);
			admusuario.validarAcceso(user, clave, opcion_ingreso);
			
			assertNotNull(admusuario);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}
	
	@Test
	public void ejecutarLogonincorrectamente() throws ClienteException {

		// [1] Datos de ejemplo para Usuario
		String user = "hespiritu";
		String clave = "abcd";
        String opcion_ingreso = "Registro de Bastanteo";
	

		try {
		
			// [03] Ejecutamos el Logon de usuario
			admusuario.logon(user, clave);
			admusuario.validarAcceso(user, clave, opcion_ingreso);
			
			assertNotNull(admusuario);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void ejecutarLogoncorrectamenteynotienepermiso() throws ClienteException {

		// [1] Datos de ejemplo para Usuario
		String user = "jalcantara";
		String clave = "8520";
        String opcion_ingreso = "Registro de Bastanteo";
	

		try {
		
			// [03] Ejecutamos el Logon de usuario
			admusuario.logon(user, clave);
			admusuario.validarAcceso(user, clave, opcion_ingreso);
			
			assertNotNull(admusuario);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}
	
	@Test
	public void siRegistrarUsuarioduplicado() throws ClienteException {

		String codigo = "U001";
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
		String user = "hespiritu";
		String clave = "abc";
		String rol = "Administrador";

		try {


			// ejecutar
			admusuario.registrarUsuario(codigo, nombre, documento, email, user,
					clave, rol);

			// Verificar
			assertNotNull(admusuario);

		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void siRegistrarRol() throws ClienteException {

		String nombre = "Usuario";
		String opcion = "Registro de Clientes";

		try {


			// ejecutar
			admusuario.RegistrarRol(nombre, opcion);

			// Verificar
			assertNotNull(admusuario);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
