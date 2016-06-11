package it.uniroma3.siw_progetto.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.TipoEsame;

 

public class ListTipoesame implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
		List<TipoEsame> Tipoesami = accessPoint.getTuttiTipoEsame();
		request.setAttribute("tipoesami",Tipoesami);
		return "/NostriEsami.jsp";
	}

}
