package bastanteo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConsultasTest {
	public AdmClientes registrarVariosClientes() throws ClienteException {
		AdmClientes admcliente = new AdmClientes();
		// Cliente 1
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;
		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);
		// Cliente 2
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
		AdmPoderes admpoder = new AdmPoderes();
		// poder 1
		String codigo = "CHCO";
		String nombre = "Cobro de Cheques";
		String tipoProducto = "Activo";
		admpoder.registrarPoderes(codigo, nombre, tipoProducto);
		// poder 2
		codigo = "EFRE";
		nombre = "Retiro en Efectivo";
		tipoProducto = "Pasivo";
		admpoder.registrarPoderes(codigo, nombre, tipoProducto);
		return admpoder;
	}

	@Test
	public void registrarVariosBastanteos() throws ClienteException {
		// registro de varios clientes
		AdmClientes admcli = new AdmClientes();
		admcli = registrarVariosClientes();
		// registro de varios poderes
		AdmPoderes admpoder = new AdmPoderes();
		admpoder = registrarVariosPoderes();
		// bastanteos
		AdmBastanteos admBastanteo = new AdmBastanteos();
		// Bastanteo 1
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
		// consulta de valores de 1 cliente especifico
		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		// consulta de Poder Especifico
		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);
		// registro de Bastanteo
		admBastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);
		// Bastanteo 2
		codigo = "002";
		nombrepoder = "Retiro en Efectivo";
		tiposervicio = "Activo";
		grupo = "B";
		nombrecli = "Infor Global Solutions";
		intervencion = "A Sola Firma";
		importe = 875.00;
		fechavenc = "30/04/2012";
		codigopoder = "";
		codcli = "";
		// consulta de valores de 1 cliente especifico
		codcli = admcli.clienteexisteCodigo(nombrecli);
		admcli.validarCliente(nombrecli);
		// consulta de Poder Especifico
		codigopoder = admpoder.buscarcodigoPoder(nombrepoder, tiposervicio);
		admpoder.validarPoder(nombrepoder, tiposervicio);
		// registro de Bastanteo
		admBastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli,
				intervencion, importe, fechavenc);
		assertEquals(2, admBastanteo.bastanteos.size());
		// return admBastanteo;
	}
}
