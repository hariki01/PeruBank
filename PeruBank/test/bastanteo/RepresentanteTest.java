package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepresentanteTest {

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
        Representante representante = new Representante(codigo,nombres, apellidos,tipodoc,ndoc, cargo, grupo,codcli);
		
		
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
