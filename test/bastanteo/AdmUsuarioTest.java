package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmUsuarioTest {

	@Test
	public void ejecutarLogon() throws ClienteException {

		// [1] Datos de ejemplo para Usuario
		String codigo = "U001";
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
		String user = "hespiritu";
		String clave = "abc";
		String rol = "Usuario";
        String opcion_ingreso = "Registro de Bastanteo";
		// [2] Datos de ejemplo para Rol
		String nombreRol = "Usuario";
		String opcion = "Registro de Bastanteo";

		boolean accesoUsuarioConcedido = false;

		try {
			// [01] Usuarios
			// Creamos una instancia de la clase AdmUsuario
			AdmUsuario adm = new AdmUsuario();

			// Ejecutamos registro de nuevo usuario
			adm.registrarUsuario(codigo, nombre, documento, email, user, clave,
					rol);

			// [02] Roles:
			// Ejecutamos registro de nuevo Rol
			adm.RegistrarRol(nombreRol, opcion);

			// [03] Ejecutamos el Logon de usuario
			adm.logon(user, clave);
			adm.validarAcceso(user, clave, opcion_ingreso);
			
			assertNotNull(adm);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void siRegistrarUsuario() throws ClienteException {

		String codigo = "U001";
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
		String user = "hespiritu";
		String clave = "abc";
		String rol = "Administrador";

		try {

			AdmUsuario admUsuario = new AdmUsuario();

			// ejecutar
			admUsuario.registrarUsuario(codigo, nombre, documento, email, user,
					clave, rol);

			// Verificar
			assertNotNull(admUsuario);

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

			AdmUsuario admUsuario = new AdmUsuario();

			// ejecutar
			admUsuario.RegistrarRol(nombre, opcion);

			// Verificar
			assertNotNull(admUsuario);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}

	}

}
