package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AdmLlenarDatos {

	public AdmClientes registrarVariosClientes() throws ClienteException {

		AdmClientes admcliente = new AdmClientes();

		// 1. CLIENTE
		String ruc = "12232720907";
		String codigo = "CL001";
		String razonSocial = "Extreme IT Solutions";
		String fechaInicio = "01/01/2010";
		String tipoEmpresa = "SAC";
		int empleados = 10;

		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// 2. CLIENTE
		ruc = "34509863021";
		codigo = "CL002";
		razonSocial = "Infor Global Solutions";
		fechaInicio = "02/06/2010";
		tipoEmpresa = "SAC";
		empleados = 30;

		admcliente.registrarCliente(codigo, ruc, razonSocial, fechaInicio,
				tipoEmpresa, empleados);

		// System.out.println("Registro Satisfactoriamente los Clientes...");

		return admcliente;

	}

	public AdmPoderes registrarVariosPoderes() throws ClienteException {

		AdmPoderes admpoder = new AdmPoderes();

		String codigo = "CHCO";
		String nombre = "Cobro de Cheques";
		String tipoProducto = "Activo";

		admpoder.registrarPoderes(codigo, nombre, tipoProducto);

		codigo = "EFRE";
		nombre = "Retiro en Efectivo";
		tipoProducto = "Pasivo";

		admpoder.registrarPoderes(codigo, nombre, tipoProducto);

		// System.out.println("Registro Satisfactoriamente los Poderes...");

		return admpoder;

	}
	
	public AdmRepresentantes registrarVariosRepresentantes() throws ClienteException{
		
		AdmRepresentantes admrep = new AdmRepresentantes();
		
		//1. Representante
		String codigo = "REP001";
		String nombres = "Luis Carlos";
		String apellidos = "Rodriguez Rojas";
		String tipodoc = "Dni";
		String ndoc = "89654023";
		String cargo = "Gerente";
		String grupo = "A";
		String codcli = "CL001";

		admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		//2. Representante
		codigo = "REP002";
		nombres = "Jose";
		apellidos = "Diaz Diaz";
		tipodoc = "Dni";
		ndoc = "12345678";
		cargo = "Gerente";
		grupo = "B";
		codcli = "CL002";

		admrep.registrarRepresentante(codigo, nombres, apellidos, tipodoc, ndoc, cargo, grupo, codcli);
		
		return admrep; 
	}

	public AdmBastanteos registrarVariosBastanteos() throws ClienteException {
		
		AdmBastanteos admbastanteo = new AdmBastanteos();
		
		//1. Bastanteo
		String codigo = "001";
		String codigopoder = "CHCO";
		//String nombrepoder = "Cobro de Cheques";
		//String tiposervicio = "Activo";
		String grupo = "A";
		//String nombrecli = "Extreme IT Solutions";
		String codcli = "CL001";
		String intervencion = "A Sola Firma";
		double importe = 500.00;
		String fechavenc = "05/12/2011";

		admbastanteo.registrarBastanteo(codigo, codigopoder, grupo, codcli, intervencion, importe, fechavenc);
		
		return admbastanteo;

	}
}
