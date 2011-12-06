package bastanteo;

import java.util.List;

public class Consulta extends AdmBastanteos {

	public Consulta(){
		
	}
	
	
	public AdmBastanteos ConsultaPoderes(String RUC, String idRepresentante, String grupoBastanteo, 
			AdmClientes admcli, AdmRepresentantes admrep, AdmBastanteos admbast) 
			throws ClienteException {
		
		AdmBastanteos resultBastanteos = new AdmBastanteos();
		
		String codCliente = admcli.clienteExisteRuc(RUC);
		Representante r = admrep.buscarRepresentanteXCodigo(idRepresentante);
		
		for (Bastanteo bastanteo : admbast.bastanteos){
			if (bastanteo.getCodCli().equals(codCliente)  && bastanteo.getGrupo().equals(grupoBastanteo)) { 
				resultBastanteos.bastanteos.add(bastanteo);
			}
		}
		
		if (resultBastanteos.bastanteos.size()==0) 
			resultBastanteos=null;
		return resultBastanteos;
		
	}

	
}
