package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;



import it.uniroma3.siw_progetto.helper.Helpercercamedico;
import it.uniroma3.siw_progetto.model.*;

public class CercaMedico implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		Helpercercamedico helper = new Helpercercamedico();
		if(helper.isValid(request)){
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
		Medico medico = accessPoint.getMedico(nome,cognome);
		//List<EsameEffettuato> esamieffettuati= accessPoint.VisualizzaEsamiMedico(medico);
		//accessPoint.closeEntityManagerFactory();
		request.setAttribute("medico", medico);
		return "/Esamimedico.jsp";
		}
		return "/Esamimedico.jsp";
	}

}
