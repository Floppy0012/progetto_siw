package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.model.TipoEsame;

public class HelperPrerequisiti {

	public boolean isValid(HttpServletRequest request) {
		TipoEsame tipoesame = (TipoEsame) request.getAttribute("TipoEsame");
		boolean errori = false;
		if(tipoesame==null){
			errori=true;			
		}
		return !errori;
	}

}
