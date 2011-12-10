package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsultasTest {

	AdmLlenarDatos admDatos;
	AdmLlenarDatos adm = new AdmLlenarDatos();
	AdmClientes admcli = new AdmClientes();
	AdmPoderes admpoder = new AdmPoderes();
	AdmRepresentantes admrep = new AdmRepresentantes();
	AdmBastanteos admbastanteo = new AdmBastanteos();
	AdmUsuario admusuario = new AdmUsuario();
	String codUsuario = "";

	@Before
	public void ValidarUsuario() throws ClienteException {

		String opcion = "Consulta de Poderes";
		String usuario = "lflores";
		String clave = "123456";

		admusuario.logon(usuario, clave);
		admusuario.validarAcceso(usuario, clave, opcion);
		codUsuario = admusuario.codigoUsuario(usuario, clave);

	}

	@Before
	public void llenarDatos() throws ClienteException {
		admcli = adm.registrarVariosClientes();
		admpoder = adm.registrarVariosPoderes();
		admrep = adm.registrarVariosRepresentantes();
		admbastanteo = adm.registrarVariosBastanteos();
		admusuario = adm.registrarVariosUsuarios();
	}

	@Test
	public void deberiaConsultarPoderesYRetornarBastanteo()
			throws ClienteException {

		Consulta consulta = new Consulta();
		AdmBastanteos respuesta = null;

		respuesta = consulta.ConsultaPoderes("12232720907", "REP001", "A",
				admcli, admrep, admbastanteo);

		assertEquals(1, respuesta.bastanteos.size());
		assertNotNull(respuesta);
	}

	@Test
	public void deberiaConsultarPoderesYRetornarNull() throws ClienteException {

		Consulta consulta = new Consulta();
		AdmBastanteos respuesta = null;

		respuesta = consulta.ConsultaPoderes("12232X0X", "REP001", "A", admcli,
				admrep, admbastanteo);

		assertNull(respuesta);
	}

}