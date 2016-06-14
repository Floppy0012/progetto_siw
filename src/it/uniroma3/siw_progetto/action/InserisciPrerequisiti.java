package it.uniroma3.siw_progetto.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperPrerequisiti;
import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.Prerequisito;
import it.uniroma3.siw_progetto.model.TipoEsame;

public class InserisciPrerequisiti implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperPrerequisiti helper = new HelperPrerequisiti();
		if (helper.isValid(request)){
		String[] prerequisiti = request.getParameterValues("prerequisiti");
		List<Prerequisito> prerequisitilist = new ArrayList<>();
		ClinicaAccessPoint accessPoint= new ClinicaAccessPoint();
		for ( int i=0; i<prerequisiti.length; i++){
			Prerequisito prerequisito= accessPoint.getprerequisito(prerequisiti[i]);
			prerequisitilist.add(prerequisito);
		}
		accessPoint.closeEntityManagerFactory();
		ClinicaAccessPoint point= new ClinicaAccessPoint();
		TipoEsame tipoEsame= (TipoEsame) request.getAttribute("TipoEsame");
		point.updateTipoesame(tipoEsame);
		point.closeEntityManagerFactory();
		tipoEsame.setPrerequisiti(prerequisitilist);
		
		request.setAttribute("TipoEsame",tipoEsame);
		
		return "/tipoesame.jsp";
	}
		return "/scegliprerequisito.jsp";
	}
}