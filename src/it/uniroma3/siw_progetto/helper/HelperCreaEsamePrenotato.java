package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperCreaEsamePrenotato {

	public boolean isValid(HttpServletRequest request) {
		String TipoEsame = request.getParameter("tipiEsami");
		boolean errori = false;
		if(TipoEsame == null){
			errori = true;
			request.setAttribute("TipoEsameError", "Devi scegliere un tipo esame");
		}
		return !errori;
	}

}
