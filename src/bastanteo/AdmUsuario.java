

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
			String user, String clave, String rol) {
		
				
		// Creamos un usuario
		Usuario newUsuario = new Usuario(nombre, documento, email, user, clave, clave);
					
		// Verificamos que se haya creado un cliente
		assertNotNull(newUsuario);
			        
		return newUsuario;
	
	}

	public Rol RegistrarRol(String nombre, String opcion) {
		// Creamos un usuario
		Rol newRol = new Rol(nombre, opcion);
							
		// Verificamos que se haya creado un cliente
		assertNotNull(newRol);
					        
		return newRol;
	}
	
	//Ingreso al sistema
	public void logon(String user, String clave){
				
			Usuario usuario = encuentraUsuario(user,clave);
		
			if (! usuario.getNombre().equals("")){
				System.out.println("El usuario: " + user);
				
				for(Rol rol : roles){
					
					if(rol.getNombre().equals(usuario.getRol()))
					{
						System.out.println("Tiene acceso a la opcion:" + rol.getOpcion());		
					}
				}
				
			}
			else{
				System.out.println("El usuario: " + user + "o la clave: " + clave);
				System.out.println("No Existen! Favor de intentar nuevamente");
			}
				
	}
	
	//Validación de usuario
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
