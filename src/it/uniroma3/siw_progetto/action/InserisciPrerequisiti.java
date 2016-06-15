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
		//DANI È POSSIBILE CHE FALLISCA QUESTA IF??? 
		if(helper.isValid(request)){
			String nometipoesame= request.getParameter("nome");
			String[] prerequisiti = request.getParameterValues("prerequisiti");
			List<Prerequisito> prerequisitilist = new ArrayList<>();
			ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
			for ( int i=0; i<prerequisiti.length; i++){
				Prerequisito prerequisito = accessPoint.getprerequisito(prerequisiti[i]);
				prerequisitilist.add(prerequisito);
			}
			//	accessPoint.closeEntityManagerFactory();
			ClinicaAccessPoint point = new ClinicaAccessPoint();

			TipoEsame tipoEsame = point.PrendiTipoesame(nometipoesame);
			//provo a riprenderlo dal database
			/*------>  TipoEsame tipoEsame = point.getTipoEsame(((TipoEsame) request.getAttribute("TipoEsame")).getId());*/
			tipoEsame.setPrerequisiti(prerequisitilist);
			point.updateTipoesame(tipoEsame);

			//	point.closeEntityManagerFactory();
			//tipoEsame.setPrerequisiti(prerequisitilist);//lo sposto su

			request.setAttribute("tipoesame",tipoEsame);

			return "/tipoesame.jsp";
		}

		return "/paginaerrorePrerequisiti.jsp";
	}
}

