package bastanteo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
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
	public void usuarioAdd() throws ClienteException{
		
		String codigo = "U005";
		String nombre = "Carlos Ruis";
		String documento = "80236512";
		String email = "carlos_ruiz@hotmail.com";
        String user = "cruiz";
        String clave = "12345";
        String rol = "Abogado";
             //destimo                  
        Usuario usuario = new Usuario(codigo,nombre,documento,email,user,clave,rol);
        
        assertEquals(codigo, usuario.getCodusu());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(documento,usuario.getDocumento());
        assertEquals(email, usuario.getEmail());
        assertEquals(user, usuario.getUser());
        assertEquals(clave, usuario.getClave());
        assertEquals(rol, usuario.getRol());   
        
	}

}
