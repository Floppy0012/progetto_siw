package it.uniroma3.siw_progetto.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.Prerequisito;

public class ListaPrerequisiti implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		ClinicaAccessPoint accessPoint= new ClinicaAccessPoint();
		List<Prerequisito> prerequisiti= accessPoint.getTuttiPrerequisiti();
		request.setAttribute("prerequisiti", prerequisiti);
		return "/InserisciTipologiaEsame.jsp";
	}

}
