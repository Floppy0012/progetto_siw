package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperCreaEsamePrenotato;
import it.uniroma3.siw_progetto.model.*;

public class CreaEsameprenotato implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperCreaEsamePrenotato helper = new HelperCreaEsamePrenotato();
		if(helper.isValid(request)){
			String cf= request.getParameter("CodiceFiscale"); 
			String nomete= request.getParameter("tipiEsami");
			ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
			Paziente P = accessPoint.getPaziente(cf);
			TipoEsame TE = accessPoint.PrendiTipoesame(nomete);
			EsamePrenotato esameprenotato = accessPoint.CreaPrenotazione(P, TE);
			P.AddEsamePrenotato(esameprenotato);
			accessPoint.updatePaziente(P);
			
			String InfoPrenotazione = esameprenotato.toString();
			
			request.setAttribute("InfoPrenotazione", InfoPrenotazione);
			
			return "/PrenotazioneEffettuata.jsp";
		}
		return "/CreazioneEsamePrenotato.jsp";
	}

}
