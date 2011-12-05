package bastanteo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AdmUsuario {
	
	List<Usuario> usuarios;
	List<Rol> roles;
	

	public AdmUsuario(){
		usuarios = new ArrayList<Usuario>();
		roles = new ArrayList<Rol>();
				
	}
	
	public Usuario registrarUsuario(String nombre, String documento, String email,
			String user, String clave, String rol) throws ClienteException {

		//Validamos los datos de usuario
		validarDatosUsuario(nombre, documento, email, user, clave, rol);
		
		//Validadmos que no exista un usuario con el mismo "documento, email, user" previamente
		validarDuplicado(documento,email,user);
		
		// Creamos un usuario
		Usuario newUsuario = new Usuario(nombre, documento, email, user, clave, rol);
					
		// Verificamos que se haya creado un cliente
		assertNotNull(newUsuario);
			        
		return newUsuario;
	}

	public Rol RegistrarRol(String nombre, String opcion) throws ClienteException {
		// Creamos un usuario
		Rol newRol = new Rol(nombre, opcion);
		
		validarDuplicado(nombre,opcion);
							
		// Verificamos que se haya creado un rol
		assertNotNull(newRol);
					        
		return newRol;
	}
	
	
	private void validarDatosUsuario(String nombre, String documento, String email,
			String user, String clave, String rol) throws ClienteException {
		String mensaje = "";
		if (nombre.equals(""))
			mensaje += "Nombre de Usuario no puede ser vacio";
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
	
	private void validarDuplicado(String documento, String email, String user)
			throws ClienteException {

		if (usuarioExiste(documento, email, user))
			throw new ClienteException("Usuario Ya Existe!, Favor de intentar nuevamente.");
	}
	
	private boolean usuarioExiste(String documento, String email, String user) {
		boolean existe = false;

		for (Usuario usuario : usuarios)
			if (usuario.getDocumento().equals(documento)
					|| usuario.getEmail().equals(email) || usuario.getUser().equals(user))
				existe = true;
		return existe;
	}
	
	
	private void validarDuplicado(String nombreRol, String opcion)
			throws ClienteException {

		if (rolExiste(nombreRol, opcion))
			throw new ClienteException("El rol ya tiene asociado la opción enviada");
	}
		
	private boolean rolExiste(String nombreRol, String opcion) {
		boolean existe = false;

		for (Rol rol : roles)
			if (rol.getNombre().equals(nombreRol)
					&& rol.getOpcion().equals(opcion))
				existe = true;
		return existe;
	}
	
	//----------------------------------------------------------------------------------------------
	//Ingreso al sistema
	//----------------------------------------------------------------------------------------------
	public boolean logon(String user, String clave, String opcion) throws ClienteException{
				
			Usuario usuario = encuentraUsuario(user,clave);
		
			if (! usuario.getNombre().equals("")){
				System.out.println("El usuario: " + user);
				
				for(Rol rol : roles){
					
					if(rol.getNombre().equals(usuario.getRol()))
					{
			//			System.out.println("Tiene acceso a la opcion:" + rol.getOpcion());
						return true;
					}
				}
				
			}
			else{
				System.out.println("El usuario: " + user + "o la clave: " + clave);
				System.out.println("No Existen! Favor de intentar nuevamente");
			}
			
			return false;
	}
	
	//----------------------------------------------------------------------------------------------
	//Validación de usuario
	//----------------------------------------------------------------------------------------------
	public Usuario encuentraUsuario(String user, String clave) {
		Usuario getUsuario = new Usuario();
		for(Usuario usuario : usuarios){
			if(usuario.getUser().equals(user) && usuario.getClave().equals(clave))
			{
				return usuario;
			}
		}
		
		return getUsuario;
	 }

}
