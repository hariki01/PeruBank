package bastanteo;

import java.util.ArrayList;
import java.util.List;

public class AdmCombinacion {

	List<Combinacion> combinaciones;

	// 2do. En el constructor inicializo
	public AdmCombinacion() {
		combinaciones = new ArrayList<Combinacion>();
	}

	public void registrarCombinacion(String codigo, String grupo,
			String combinacion) throws ClienteException {

		// Guardando en poder grupo

		// añaden a la lista
	//	if (combinacion=="En Conjunto Con") {
			validarDatos(codigo, grupo, combinacion);
			validarCombinacion(codigo, grupo, combinacion);
			Combinacion nuevoCombinacion = new Combinacion(codigo, grupo,
					combinacion);

			combinaciones.add(nuevoCombinacion);
	//	}
	}

	private void validarDatos(String codigo, String grupo, String combinacion)
			throws ClienteException {
		String mensaje = "";
		if (codigo.equals(""))
			mensaje += "Codigo no puede ser vacio";
		if (grupo.equals(""))
			mensaje += "\nGrupo a combinar no puede ser vacio";
		if (combinacion.equals(""))
			mensaje += "\nIntervencion no puede ser vacio";
		if (!mensaje.equals(""))
			throw new ClienteException(mensaje);
	}

	public String bastanteoexistecombinacion(String codigo, String grupo) {
		String cod = "";

		// and && , || or
		for (Combinacion combinacion : combinaciones)
			if (combinacion.getCodigo().equals(codigo)
					&& combinacion.getGrupo().equals(grupo))
				cod = combinacion.getCodigo();
		return cod;
	}

	public void validarCombinacion(String codigo, String grupo,
			String combinacion) throws ClienteException {
		String cod = "";
		cod = bastanteoexistecombinacion(codigo, grupo);
		if (cod != "" && combinacion.equals("En Conjunto Con"))
			throw new ClienteException("Combinacion existente");
	}

}
