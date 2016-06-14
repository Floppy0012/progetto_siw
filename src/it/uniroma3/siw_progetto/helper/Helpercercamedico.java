package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class Helpercercamedico {

	public boolean isValid(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		boolean errori = false;

		if(nome == null || nome.equals("")){
			errori = true;
			request.setAttribute("nomeError", "Nome è obbligatorio");
		}

		if(cognome == null || cognome.equals("")){
			errori = true;
			request.setAttribute("cognomeError", "Cognome è obbligatoria");
		}

		return !errori;

	}
}
