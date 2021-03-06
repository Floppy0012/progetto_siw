package it.uniroma3.siw_progetto.controller;

import java.io.IOException;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.uniroma3.siw_progetto.action.Action;

@WebServlet("/controller/*")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = null;
		String actionName = CreaNomeAzione(request);
		Action action;
		try{
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.perform(request);
		} catch (Exception e){
			nextPage = "/paginaerrore.jsp";
			
		}
		nextPage = response.encodeURL(nextPage);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	private String CreaNomeAzione(HttpServletRequest request) {
		String path = request.getPathInfo();
		
		String modelCommand = path.substring(1);
		Scanner scanner = new Scanner(modelCommand).useDelimiter("\\.");
		String model = scanner.next();
		model = model.substring(0,1).toUpperCase() + model.substring(1);
		
		String action = scanner.next();
		action = action.substring(0,1).toUpperCase() + action.substring(1);
		String actionname = "it.uniroma3.siw_progetto.action." + action + model;
		return actionname;
	}

}
