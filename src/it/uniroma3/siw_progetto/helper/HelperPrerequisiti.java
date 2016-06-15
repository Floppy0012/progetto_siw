package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperPrerequisiti {
	public boolean isValid( HttpServletRequest request) {
		String tipoesame= request.getParameter("nome");
		String[] prereqiusiti= request.getParameterValues("prerequisiti");
		boolean errori = false;
		if(tipoesame == null){
			errori = true;			
		}

		if (prereqiusiti.length == 0 ){
			errori = true;
		}

		return !errori;
	}

}
