package bastanteo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {
	
	@Test
	public void usuarioAdd() throws ClienteException{
		
		String codigo = "U001";
		String nombre = "HANS ESPIRITU";
		String documento = "12345678";
		String email = "HANS@HOTMAIL.COM";
        String user = "hespiritu";
        String clave = "abc";
        String rol = "ADMINISTRADOR";
             //destimo                  
		Usuario usuario = new Usuario(codigo,nombre,documento,email,user,clave,rol);
		
		assertEquals(nombre, usuario.getNombre());
        assertEquals(documento, usuario.getDocumento());
        assertEquals(email, usuario.getEmail());
        assertEquals(usuario, usuario.getUser());
        assertEquals(clave, usuario.getClave());
        assertEquals(rol, usuario.getRol());   
        
	}

}
