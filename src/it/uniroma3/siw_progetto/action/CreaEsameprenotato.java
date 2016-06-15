package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperCreaEsamePrenotato;
import it.uniroma3.siw_progetto.model.*;

public class CreaEsameprenotato implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperCreaEsamePrenotato helper = new HelperCreaEsamePrenotato();
		if(helper.isValid(request)){
			ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
			Paziente P = accessPoint.getPaziente(request.getParameter("CodiceFiscale"));
			TipoEsame TE = accessPoint.PrendiTipoesame(request.getParameter("tipiEsami"));
			EsamePrenotato esameprenotato = accessPoint.CreaPrenotazione(P, TE);
			String InfoPrenotazione = esameprenotato.toString();
			request.setAttribute("InfoPrenotazione", InfoPrenotazione);
			return "/PrenotazioneEffettuata.jsp";
		}
		return "/CreaEsameScegliTipoEsame.jsp";
	}

}
