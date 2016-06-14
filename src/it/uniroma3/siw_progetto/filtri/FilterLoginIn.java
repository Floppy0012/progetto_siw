package it.uniroma3.siw_progetto.filtri;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterLoginIn implements Filter {

	private ServletContext application;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (session.getAttribute("utente")==null) {
			RequestDispatcher rd  = this.application.getRequestDispatcher("/admin/login.do");
			rd.forward(request, response);	
		}
		else {
			chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {		
		this.application = fConfig.getServletContext();	
	}

	public void destroy() {		
	}



}