package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperTipoesame;
import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.TipoEsame;

public class CreaTipoesame implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		HelperTipoesame helper = new HelperTipoesame();

		if(helper.isValid(request)){
			String name = request.getParameter("NomeTipo");
			String descrizione = request.getParameter("DescrizioneTipo");
			Float costo = Float.parseFloat(request.getParameter("CostoTipo"));

			ClinicaAccessPoint clinica = new ClinicaAccessPoint();
			TipoEsame TEs = clinica.CreaNuovaTipologiaEsame(name, descrizione, costo, null);
			request.setAttribute("TipoEsame", TEs);

			return "/ConfermaTipoEsame.jsp";
		}
		return "/InserimentoTipoEsame.jsp";
	}



}
