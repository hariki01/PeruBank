package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmUsuarioTest {
	
	@Test
	public void ejecutarLogon() throws ClienteException{
		
		//[1] Datos de ejemplo para Usuario
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
        String user = "hespiritu";
        String clave = "abc";
        String rol = "ADMINISTRADOR";

    	//[2] Datos de ejemplo para Rol
        String nombreRol = "ADMINISTRADOR";
		String opcion = "BASTANTEO";
		
        boolean accesoUsuarioConcedido = false;
		
        try {
        	//[01] Usuarios
    		//Creamos una instancia de la clase AdmUsuario
    		AdmUsuario adm = new AdmUsuario();

            //Ejecutamos registro de nuevo usuario
            adm.registrarUsuario(nombre,documento,email,user,clave,rol);

            //[02] Roles:
   			//Ejecutamos registro de nuevo Rol
    		adm.RegistrarRol(nombreRol, opcion);
    		
    		//[03] Ejecutamos el Logon de usuario
    		accesoUsuarioConcedido = adm.logon(user, clave, opcion);
    		
    		 assertNotNull(adm);
		}

		catch (ClienteException ex) {
			System.out.println(ex);
		}
        
	}

	@Test
	public void siRegistrarUsuario() throws ClienteException{
		
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
	public void siRegistrarRol() throws ClienteException{
		
		String nombre = "ADMINISTRADOR";
		String opcion = "AGREGAR";
		        
        AdmUsuario admUsuario = new AdmUsuario();	
		
        //ejecutar
        Rol rol = admUsuario.RegistrarRol(nombre, opcion);
        
       // Verificar
        assertNotNull(rol);
	}
	
}
