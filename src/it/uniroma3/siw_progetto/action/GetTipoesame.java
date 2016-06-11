package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperTipoesameid;
import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.TipoEsame;

public class GetTipoesame implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperTipoesameid helper= new HelperTipoesameid(); 
		if (helper.isValid(request)){
			Long id= Long.parseLong(request.getParameter("id"));
			ClinicaAccessPoint accessPoint= new ClinicaAccessPoint();
			TipoEsame tes= accessPoint.getTipoEsame(id);
			request.setAttribute("tipoesame", tes);
			return "/tipoesame.jsp";
		}
		return "/pagginaerrore";
	}

}
