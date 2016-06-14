package it.uniroma3.siw_progetto.helper;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import it.uniroma3.siw_progetto.model.Prerequisito;
import it.uniroma3.siw_progetto.model.TipoEsame;

public class HelperPrerequisiti {

	public boolean isValid(HttpServletRequest request) {
		TipoEsame tipoesame = (TipoEsame) request.getAttribute("TipoEsame");
		//List<Prerequisito> prerequisiti = (List<Prerequisito>) request.getAttribute("prerequisiti");
		boolean errori = false;
		if(tipoesame == null){
	//		if(prerequisiti == null){
		errori = true;			
		}
		return !errori;
	}

}
