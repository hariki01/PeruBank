package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RepresentanteTest {
	
	AdmUsuario admusuario = new AdmUsuario();

	String codUsuario = "";
	AdmLlenarDatos adm = new AdmLlenarDatos();

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Registro de Representantes";
		String usuario = "hbruno";
		String clave = "2210";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void LlenarDatos() throws ClienteException {
		admusuario = adm.registrarVariosUsuarios();
	}

	@Test
	public void representanteDeberiaCrearseConDatosIniciales() throws ClienteException {

		// Preparo el escenario
		String codigo= "REP001";
		String nombres = "Luis Carlos";
		String apellidos = "Rodriguez Rojas";
		String tipodoc = "Dni";
		String ndoc = "89654023";
		String cargo = "Gerente";
		String grupo = "A";
		String codcli = "CL001";
		
		//Ejecuto el escenario
        Representante representante = new Representante(codigo,nombres, apellidos,
        tipodoc,ndoc, cargo, grupo,codcli,codUsuario);
		
		
		//Verifico
        assertEquals(nombres, representante.getNombres());
        assertEquals(apellidos,representante.getApellidos());
        assertEquals(tipodoc, representante.getTipodoc());
        assertEquals(ndoc, representante.getNdoc());
        assertEquals(cargo,representante.getCargo());
        assertEquals(grupo,representante.getGrupo());   
        assertEquals(codcli,representante.getCodcli());   
		

	}

}
