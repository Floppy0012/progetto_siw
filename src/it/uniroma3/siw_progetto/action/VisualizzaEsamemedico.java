package it.uniroma3.siw_progetto.action;

import javax.servlet.http.HttpServletRequest;

public class VisualizzaEsamemedico implements Action {

	@Override
	public String perform(HttpServletRequest request) {

		return "/Base.jsp";
	}

}
