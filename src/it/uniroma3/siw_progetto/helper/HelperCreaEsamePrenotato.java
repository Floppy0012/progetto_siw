package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperCreaEsamePrenotato {

	public boolean isValid(HttpServletRequest request) {
		String TipoEsame = request.getParameter("tipiEsami");
		String CF = request.getParameter("CodiceFiscale");
		String nomePaziente = request.getParameter("nomePaziente");
		String cognomePaziente = request.getParameter("cognomePaziente");
		boolean errori = false;
		if(TipoEsame == null){
			errori = true;
			request.setAttribute("TipoEsameError", "Scegli un tipo esame");
			request.setAttribute("CodiceFiscale", CF);
			request.setAttribute("nomePaziente", nomePaziente);
			request.setAttribute("cognomePaziente", cognomePaziente);
		}
		return !errori;
	}

}
