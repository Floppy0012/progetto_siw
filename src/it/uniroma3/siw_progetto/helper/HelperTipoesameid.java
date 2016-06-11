package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperTipoesameid {

	public boolean isValid(HttpServletRequest request) {
		String id=request.getParameter("id");
		boolean errori = false;
		if (id== null || id.equals("")){
			errori= true;
			request.setAttribute("idError", "id non valido");
		}else 
		{
			try{
				Long.parseLong(id);
				}
			catch(NumberFormatException e){
				errori= true;
				request.setAttribute("id", "id non valido");
			}
		}
		return !errori;
	}

}
