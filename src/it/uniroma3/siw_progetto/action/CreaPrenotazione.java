package it.uniroma3.siw_progetto.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperCreaPrenotazione;
import it.uniroma3.siw_progetto.model.*;

public class CreaPrenotazione implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperCreaPrenotazione helper = new HelperCreaPrenotazione();
		if(helper.isValid(request)){
			String CF = request.getParameter("CodiceFiscale");
			ClinicaAccessPoint accesspoint = new ClinicaAccessPoint();
			List<TipoEsame> tipiEsami = accesspoint.getTuttiTipoEsame();
			Paziente P = accesspoint.getPaziente(CF);
			
			request.setAttribute("CodiceFiscale", CF);
			request.setAttribute("nomePaziente", P.getNome());
			request.setAttribute("cognomePaziente", P.getCognome());
			request.setAttribute("tipiEsami", tipiEsami);
		
			return "/CreaEsameScegliTipoEsame.jsp";	
		}
		return "/CreazioneEsamePrenotato.jsp";
	}

}
