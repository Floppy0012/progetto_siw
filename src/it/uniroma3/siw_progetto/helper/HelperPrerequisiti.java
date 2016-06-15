package it.uniroma3.siw_progetto.helper;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class HelperPrerequisiti {

	public boolean isValid( HttpServletRequest request) {
		String tipoesame= request.getParameter("nome");
		String[] prereqiusiti= request.getParameterValues("prerequisiti");
		//List<Prerequisito> prerequisiti = (List<Prerequisito>) request.getAttribute("prerequisiti");
		boolean errori = false;
		if(tipoesame == null){
	//		if(prerequisiti == null){
		errori = true;			
		}
	
		if (prereqiusiti.length==0 ){
			errori = true;
		}
			
		return !errori;
	}

}
