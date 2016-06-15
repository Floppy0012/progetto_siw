package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperCreaPrenotazione {

	public boolean isValid(HttpServletRequest request) {
		String Cf = request.getParameter("CodiceFiscale");
		boolean errori = false;
		if( Cf == null || Cf.equals("")){
			errori = true;
			request.setAttribute("CodiceFiscaleError", "Il codice fiscale non è corretto");
			
		}
		return !errori;
	}

}
