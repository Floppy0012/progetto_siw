package it.uniroma3.siw_progetto.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw_progetto.helper.HelperTipoesame;
import it.uniroma3.siw_progetto.model.ClinicaAccessPoint;
import it.uniroma3.siw_progetto.model.Prerequisito;
import it.uniroma3.siw_progetto.model.TipoEsame;

public class CreaTipoesame implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperTipoesame helper = new HelperTipoesame();

		if(helper.isValid(request)){
			ClinicaAccessPoint clinica = new ClinicaAccessPoint();
			String name = request.getParameter("NomeTipo");
			String descrizione = request.getParameter("DescrizioneTipo");
			Float costo = Float.parseFloat(request.getParameter("CostoTipo"));
			String[] prerequisiti = request.getParameterValues("prerequisiti[]"); 
			
			List<Prerequisito> prerequisitilist = new ArrayList<>();
			for ( int i=0; i<prerequisiti.length; i++){
				Prerequisito prerequisito= clinica.getprerequisito(prerequisiti[i]);
				prerequisitilist.add(prerequisito);
			}

			TipoEsame TEs = clinica.creaTipoesame(name, descrizione, costo, prerequisitilist);
			request.setAttribute("TipoEsame", TEs);

			return "/tipoesame.jsp";
		}
		
		return "/InserisciTipologiaEsame.jsp";
	}



}
