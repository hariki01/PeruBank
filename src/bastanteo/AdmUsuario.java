package bastanteo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AdmUsuario {

	List<Usuario> usuarios;
	List<Rol> roles;

	public AdmUsuario() {
		usuarios = new ArrayList<Usuario>();
		roles = new ArrayList<Rol>();

	}

	public void registrarUsuario(String codusu, String nombre,
			String documento, String email, String user, String clave,
			String rol) throws ClienteException {
		// Validamos los datos de usuario
		validarDatosUsuario(codusu, nombre, documento, email, user, clave, rol);

		// Validadmos que no exista un usuario con el mismo
		// "documento, email, user" previamente
		validarDuplicado(codusu, documento, email, user);

		// Creamos un usuario
		Usuario newUsuario = new Usuario(codusu, nombre, documento, email,
				user, clave, rol);

		usuarios.add(newUsuario);

	}

	public void RegistrarRol(String nombre, String opcion)
			throws ClienteException {
		// Creamos un usuario
		Rol newRol = new Rol(nombre, opcion);

		validarDuplicado(nombre, opcion);

		roles.add(newRol);

	}

	private void validarDatosUsuario(String codusu, String nombre,
			String documento, String email, String user, String clave,
			String rol) throws ClienteException {
		String mensaje = "";
		if (codusu.equals(""))
			mensaje += "Codigo de Usuario no puede ser vacio";
		if (nombre.equals(""))
			mensaje += "\nNombre de Usuario no puede ser vacio";
		if (documento.equals(""))
			mensaje += "\nDocumento no puede ser vacio";
		if (email.equals(""))
			mensaje += "\nEmail social no puede ser vacio";
		if (user.equals(""))
			mensaje += "\nUser o Nick de usuario no puede ser vacio";
		if (clave.equals(""))
			mensaje += "\nDebe registrar una clave";
		if (rol.equals(""))
			mensaje += "\nDebe especificar un rol para usuario";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	private void validarDuplicado(String codusu, String documento,
			String email, String user) throws ClienteException {

		boolean existe = false;
		existe =usuarioExiste(codusu, documento, email, user);		
		
		if (existe == true)
			throw new ClienteException("Usuario Ya Existe!, Favor de intentar nuevamente.");
	}

	private boolean usuarioExiste(String codusu, String documento,
			String email, String user) {
		boolean existe = false;

		for (Usuario usuario : usuarios)
			if (usuario.getDocumento().equals(documento)
					|| usuario.getEmail().equals(email)
					|| usuario.getUser().equals(user)
					|| usuario.getCodusu().equals(codusu))
				existe = true;
		return existe;
	}

	private void validarDuplicado(String nombreRol, String opcion)
			throws ClienteException {

		if (rolExiste(nombreRol, opcion))
			throw new ClienteException(
					"El rol ya tiene asociado la opción enviada");
	}

	private boolean rolExiste(String nombreRol, String opcion) {
		boolean existe = false;

		for (Rol rol : roles)
			if (rol.getNombre().equals(nombreRol)
					&& rol.getOpcion().equals(opcion))
				existe = true;
		return existe;
	}

	// ----------------------------------------------------------------------------------------------
	// Ingreso al sistema
	// ----------------------------------------------------------------------------------------------
	public void logon(String user, String clave) throws ClienteException {
		String mensaje = "";
		String codigo = "";
		codigo = codigoUsuario(user, clave);
		
		
		if (codigo.equals("")) {
			mensaje = "El usuario: " + user + " o la clave: " + clave;
			mensaje += " No Existen! Favor de intentar nuevamente";
			throw new ClienteException(mensaje);
		}

	}

	// ----------------------------------------------------------------------------------------------
	// Validación de usuario
	// ----------------------------------------------------------------------------------------------

	public Usuario encuentraUsuario(String user, String clave) {
		for (Usuario usuario : usuarios)
			if (usuario.getUser().equals(user)
					&& usuario.getClave().equals(clave))
				return usuario;
		return null;
	}

	public String codigoUsuario(String user, String clave) {
		String codigo = "";
		for (Usuario usuario : usuarios)
			if (usuario.getUser().equals(user)
					&& usuario.getClave().equals(clave))
				codigo = usuario.getCodusu();

		return codigo;
	}

	public String rolUsuario(String user, String clave) {
		String rol = "";
		for (Usuario usuario : usuarios)
			if (usuario.getUser().equals(user)
					&& usuario.getClave().equals(clave))
				rol = usuario.getRol();

		return rol;
	}

	public boolean devuelveAcceso(String user, String clave, String opcion) {
		String perfil = "";
		perfil = rolUsuario(user, clave);
		boolean acceso = false;

		if (perfil == "Administrador") {
			acceso = true;
		} else {
			for (Rol rol : roles) {
				if (perfil.equals(rol.getNombre())
						&& opcion.equals(rol.getOpcion()))
					acceso = true;

			}
		}
		return acceso;
	}

	public void validarAcceso(String user, String clave, String opcion)
			throws ClienteException {
		boolean acceso = false;
		acceso = devuelveAcceso(user, clave, opcion);
		if (acceso == false)
			throw new ClienteException("No tiene acceso para esta opcion");

	}

}
