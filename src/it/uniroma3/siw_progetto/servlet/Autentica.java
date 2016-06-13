package it.uniroma3.siw_progetto.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.uniroma3.siw_progetto.action.LoginAction;

@WebServlet("/login.do")
public class Autentica extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    					throws IOException, ServletException {

		String prossimaPagina = "/fallimento.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String prossimaPagina = "/fallimento.jsp";
		LoginAction login = new LoginAction();
		String esito = login.esegui(request);
		if (esito.equals("OK"))
			prossimaPagina = "/risorsaProtetta.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}
}
