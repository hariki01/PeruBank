package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmClientes {

	// 1ero. defino mi lista de un tipo dado
	List<Cliente> clientes;

	// 2do. En el constructor inicializo
	public AdmClientes() {
		clientes = new ArrayList<Cliente>();
	}

	public void registrarCliente(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa, int empleados,String codusua)
			throws ClienteException {

		// validar datos
		validarDatos(codigo, ruc, razonSocial, fechaInicio, tipoEmpresa);

		// validar que no haya duplicados
		validarDuplicado(codigo, ruc);

		// Creamos un cliente
		Cliente nuevoCliente = new Cliente(codigo, ruc, razonSocial,
				fechaInicio, tipoEmpresa, empleados,codusua);
		// añaden a la lista
		clientes.add(nuevoCliente);

	}

	private void validarDuplicado(String codigo, String ruc)
			throws ClienteException {

		if (clienteExiste(codigo, ruc))
			throw new ClienteException("Cliente Duplicado");
	}
	
	public void validarCliente(String nombre) throws ClienteException {
       String codigo = "";
       codigo =clienteexisteCodigo(nombre);
		
		if (codigo=="")
			throw new ClienteException("Cliente Inexistente");
	}


	private boolean clienteExiste(String codigo, String ruc) {
		boolean existe = false;

		// and && , || or
		for (Cliente cliente : clientes)
			if (cliente.getCodigo().equals(codigo)
					|| cliente.getRuc().equals(ruc))
				existe = true;
		return existe;
	}

	public String clienteexisteCodigo(String nombre) {
		String codigo = "";

		// and && , || or
		for (Cliente cliente : clientes)
			if (cliente.getRazonSocial().equals(nombre))
				codigo = cliente.getCodigo();
		return codigo;
	}

	private void validarDatos(String codigo, String ruc, String razonSocial,
			String fechaInicio, String tipoEmpresa) throws ClienteException {
		String mensaje = "";
		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (ruc.equals(""))
			mensaje += "\nRuc no puede ser vacio";
		if (razonSocial.equals(""))
			mensaje += "\nRazon social no puede ser vacio";
		if (fechaInicio.equals(""))
			mensaje += "\nFecha de inicio no puede ser vacio";
		if (tipoEmpresa.equals(""))
			mensaje += "\nTipo de empresa no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	public Cliente buscarCliente(String codigo) {
		for (Cliente cliente : clientes)
			if (cliente.getCodigo().equals(codigo))
				return cliente;
		return null;
	}
	
	public String clienteExisteRuc(String ruc) {
		String codigo = "";

		// and && , || or
		for (Cliente cliente : clientes)
			if (cliente.getRuc().equals(ruc))
				codigo = cliente.getCodigo();
		return codigo;
	}
	
	public void validarClienteRuc(String ruc) throws ClienteException {
	       String codigo = "";
	       codigo =clienteExisteRuc(ruc);
			
			if (codigo=="")
				throw new ClienteException("RUC Invalido...");
		}

}
