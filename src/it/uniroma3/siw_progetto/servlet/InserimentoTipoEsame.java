package it.uniroma3.siw_progetto.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.siw_progetto.model.Clinica;
import it.uniroma3.siw_progetto.model.TipoEsame;

/**
 * Servlet implementation class InserimentoTipoEsame
 */
@WebServlet("/ControllerInserimentoTipoEsame")
public class InserimentoTipoEsame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoTipoEsame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		String NomeTipo = request.getParameter("NomeTipo");
		String DescrizioneTipo = request.getParameter("DescrizioneTipo");
		String Costo = request.getParameter("CostoTipo");
		
		//PRENDO IL COSTO, MA � UNA STRINGA LO CONVERTO IN FLOAT 
		float CostoTipo = Float.parseFloat(Costo);
		
		//Creo un TipoEsame e setto i valori presi dalla request
		TipoEsame TEs = new TipoEsame();
		TEs.setNome(NomeTipo);
		TEs.setDescrizione(DescrizioneTipo);
		TEs.setCosto(CostoTipo);
		
		//devo fare qua il passaggio al DB??? 
		Clinica.getInstance().saveTipoEsame(TEs);
		
		//metto i valori nella sessione
		HttpSession session = request.getSession();
		session.setAttribute("TEs", TEs);
		nextPage = "/ConfermaInserimento.jsp";
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext.getRequestDispatcher(response.encodeURL(nextPage));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}