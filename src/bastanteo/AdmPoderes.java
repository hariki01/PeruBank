package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmPoderes {
	
	List<Poderes> poderes;

	//En el constructor inicializo
	public AdmPoderes() {
		poderes = new ArrayList<Poderes>();
	}

	public void registrarPoderes(String codigo,String nombre,String tipoProducto,String codusua)
		throws ClienteException {

		//validar datos
		validarDatosPoderes(codigo, nombre, tipoProducto,codusua);
		
		//validar poderes
		validarDuplicado(nombre,tipoProducto);		

		Poderes poder = new Poderes(codigo,nombre,tipoProducto,codusua);

		// agregando los valores al areglo
		poderes.add(poder);
	}
	
	public void registrarPoderesparabastanteo(String codigo,String nombre,String tipoProducto,
			                                  String codusua )
			throws ClienteException {

			//validar datos
			validarDatosPoderes(codigo, nombre, tipoProducto,codusua);
			
			//validar poderes
			validarDuplicado(nombre,tipoProducto);		

			Poderes poder = new Poderes(codigo,nombre,tipoProducto,codusua);

			// agregando los valores al areglo
			poderes.add(poder);
		}


	private void validarDuplicado(String nombre, String tipoProducto)
			throws ClienteException {

		if (poderExiste(nombre, tipoProducto))
			throw new ClienteException("Poder Existente");
	}
	
	public void validarPoder(String nombre, String tipoProducto) throws ClienteException {
       String codigo="";
       codigo = buscarcodigoPoder(nombre,tipoProducto);
		if (codigo == "")
			throw new ClienteException("Poder Inexistente");
	}

	private void validarDatosPoderes(String codigo, String nombre,String tipoProducto,String codusua)
			throws ClienteException {

		String mensaje = "";
		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (nombre.equals(""))
			mensaje += "\nNombre no puede ser vacio";
		if (tipoProducto.equals(""))
			mensaje += "\nTipo de Producto no puede ser vacio";
		if (codusua.equals(""))
			mensaje += "\nUsuario no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}
	
	private boolean poderExiste(String nombre, String tipoProducto) {
		boolean existe = false;

		// and && , || or
		for (Poderes poder : poderes)
			if (poder.getNombre().equals(nombre) && 
				poder.getTipoProducto().equals(tipoProducto))  
				existe = true;
		return existe;
	}
	
	public Poderes buscarPoderes(String nombre,String tipoProducto) {
		for (Poderes poder : poderes)
			if (poder.getNombre().equals(nombre) && 
				poder.getTipoProducto().equals(tipoProducto))     
				return poder;
		return null;
	}
	
	public String buscarcodigoPoder(String nombre,String tipoProducto) {
	String codigo = "";
		
		for (Poderes poder : poderes)
			if (poder.getNombre().equals(nombre) && 
				poder.getTipoProducto().equals(tipoProducto))
				codigo = poder.getCodigo();
				return codigo;
		
	}

}
