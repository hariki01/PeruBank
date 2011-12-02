package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmUsuarioTest {
	
	@Test
	public void ejecutarLogon() {
		
		AdmUsuario adm = new AdmUsuario();
		
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
        String user = "hespiritu";
        String clave = "abc";
        String rol = "ADMINISTRADOR";
        //Usuario newUsuario = new Usuario();
        	
        	adm.registrarUsuario(nombre,documento,email,user,clave,rol);
      	
        
      	String nombreRol = "ADMINISTRADOR";
		String opcion = "AGREGAR";
		adm.RegistrarRol(nombreRol, opcion);
		
		
		//adm.logon(newUsuario.getUser(), newUsuario.getClave());
		
		 assertNotNull(adm);
		
	}

	@Test
	public void siRegistrarUsuario(){
		
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
        String user = "hespiritu";
        String clave = "abc";
        String rol = "ADMINISTRADOR";
        
        AdmUsuario admUsuario = new AdmUsuario();	
		
        //ejecutar
        Usuario usuario = admUsuario.registrarUsuario(nombre, documento, email,
        		user, clave, rol);
        
       // Verificar
        assertNotNull(usuario);
	}
	
	@Test
	public void siRegistrarRol(){
		
		String nombre = "ADMINISTRADOR";
		String opcion = "AGREGAR";
		        
        AdmUsuario admUsuario = new AdmUsuario();	
		
        //ejecutar
        Rol rol = admUsuario.RegistrarRol(nombre, opcion);
        
       // Verificar
        assertNotNull(rol);
	}
	
}
