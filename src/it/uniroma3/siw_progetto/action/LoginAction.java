package it.uniroma3.siw_progetto.action;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import it.uniroma3.siw_progetto.model.FacadeAutenticazione;
import it.uniroma3.siw_progetto.model.FacadeAutenticazioneImpl;
import it.uniroma3.siw_progetto.model.Utente;

public class LoginAction {

	public LoginAction(){}

	public String esegui(HttpServletRequest request) throws ServletException  {
		FacadeAutenticazione authService = new FacadeAutenticazioneImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = authService.login(username, password);
		if (utente!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utente",utente);
			return "OK";
		} else
			return "KO";
	}
}
