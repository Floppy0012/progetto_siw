package it.uniroma3.siw_progetto.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperTipoesame {

	public boolean isValid(HttpServletRequest request){
		String nome = request.getParameter("NomeTipo");
		String descrizione = request.getParameter("DescrizioneTipo");
		String costo = request.getParameter("CostoTipo");
		boolean errori = false;

		if(nome == null || nome.equals("")){
			errori = true;
			request.setAttribute("nomeError", "Nome è obbligatorio");
		}

		if(descrizione == null || descrizione.equals("")){
			errori = true;
			request.setAttribute("descrizioneError", "Descrizione è obbligatoria");
		}
		
		if(costo == null || costo.equals("")){
			errori = true;
			request.setAttribute("costoError", "Costo è obbligatorio");
		}
		else{
			try{
				Float.parseFloat(costo);
			}
			catch(NumberFormatException e){
				errori  = true;
				request.setAttribute("costoError", "Costo deve essere un numero");
			}
		}
		
		return !errori;
		

		}
	}

