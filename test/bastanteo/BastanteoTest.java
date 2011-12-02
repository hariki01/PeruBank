package bastanteo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BastanteoTest {
	
	@Test
	public void bastanteoDeberiaCrearseConDatosIniciales(){
	
		//Preparo el escenario	
        String codigo = "001";
        String codigopoder = "CHCO";
        String grupo = "A";
		String codcli ="CL001";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "01/10/2012";
		//Ejecuto el escenario
        Bastanteo bastanteo = new Bastanteo(codigo,codigopoder,grupo,codcli,intervencion,importe,fechavenc);
        
		
		//Verifico
        assertEquals(codigo, bastanteo.getCodigo());
        assertEquals(codigopoder, bastanteo.getCodigopoder());
        assertEquals(grupo, bastanteo.getGrupo());
        assertEquals(codcli, bastanteo.getCodCli());
        assertEquals(intervencion, bastanteo.getIntervencion());
        assertEquals(importe, bastanteo.getImporte(),0);   
        assertEquals(fechavenc, bastanteo.getFechaVenc());   
		
	}

}
