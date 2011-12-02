package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AdmBastanteoTest {

	public AdmClientes registrarVariosClientes() throws ClienteException {
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		AdmClientes admcliente = new AdmClientes();

		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// 2do cliente
		ruc = "34509863021";
		codigo = "CL002";
		razonSocial = "Infor Global Solutions";
		fechaInicio = "02/06/2010";
		tipoEmpresa = "SAC";
		empleados = 30;

		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		return admcliente;

	}

	public AdmPoderes registrarVariosPoderes() throws ClienteException {
		String codigo = "CHCO";
		String nombre = "Cobro de Cheques";
		String tipoProducto = "Activo";

		AdmPoderes admpoder = new AdmPoderes();

		admpoder.registrarPoderes(codigo, nombre, tipoProducto);

		codigo = "EFRE";
		nombre = "Retiro en Efectivo";
		tipoProducto = "Pasivo";

		admpoder.registrarPoderes(codigo, nombre, tipoProducto);

		return admpoder;

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoaSolafirma()
			throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);

		AdmPoderes admpoder = new AdmPoderes();
		admpoder = registrarVariosPoderes();

		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);

		AdmBastanteos admbastanteo = new AdmBastanteos();
		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);

		assertEquals(codcli, "CL001");
		assertEquals(codigopoder, "CHCO");
		assertNotNull(admbastanteo);

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoaduplicadoSolafirma()throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);

		AdmPoderes admpoder = new AdmPoderes();
		admpoder = registrarVariosPoderes();

		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);

		AdmBastanteos admbastanteo = new AdmBastanteos();
		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);
		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);

		assertEquals(codcli, "CL001");
		assertEquals(codigopoder, "CHCO");
		assertNotNull(admbastanteo);

	}

	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoconCombinacion()throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "En Conjunto Con";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);

		AdmPoderes admpoder = new AdmPoderes();
		admpoder = registrarVariosPoderes();

		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);

		AdmBastanteos admbastanteo = new AdmBastanteos();
		AdmCombinacion admcom = new AdmCombinacion();
		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);

		
		String grupos = "B";
        admcom.registrarCombinacion(codigo, grupos, intervencion);

		grupos = "C";
        admcom.registrarCombinacion(codigo, grupos, intervencion);

		assertEquals(codcli, "CL001");
		assertEquals(codigopoder, "CHCO");
		assertNotNull(admbastanteo);
        assertNotNull(admcom);
	}
	
	@Test
	public void siIngresoDatosDeberiaRegistrarBastanteoconCombinacionaexistente()throws ClienteException {

		// preparamos el ejemplo
		String codigo = "001";
		String nombrepoder = "Cobro de Cheques";
		String tiposervicio = "Activo";
		String grupo = "A";
		String nombrecli = "Extreme IT Solutions";
		String intervencion = "En Conjunto Con";
		double importe = 500.00;
		String fechavenc = "01/10/2012";

		String codigopoder = "";
		String codcli = "";

		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();

		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);

		AdmPoderes admpoder = new AdmPoderes();
		admpoder = registrarVariosPoderes();

		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);

		AdmBastanteos admbastanteo = new AdmBastanteos();
		AdmCombinacion admcom = new AdmCombinacion();
		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);

		
		String grupos = "B";
        admcom.registrarCombinacion(codigo, grupos, intervencion);

		grupos = "C";
        admcom.registrarCombinacion(codigo, grupos, intervencion);
        
    	grupos = "C";
        admcom.registrarCombinacion(codigo, grupos, intervencion);

		assertEquals(codcli, "CL001");
		assertEquals(codigopoder, "CHCO");
		assertNotNull(admbastanteo);
        assertNotNull(admcom);
	}

}
