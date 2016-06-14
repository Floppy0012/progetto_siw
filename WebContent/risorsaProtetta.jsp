<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "it.uniroma3.siw_progetto.model.Utente" %>
  <% Utente utente = (Utente)session.getAttribute("utente");
   boolean autorizzato = true;
   if (utente!=null)
	   autorizzato &= (utente.getRuolo().equals("admin"));
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/fallimento.jsp"); //possiamo inserire una pagina per il fallimento se non admin
   	   rd.forward(request, response);
	   return;
	}
%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <div> Ciao,<%out.print(utente.getUsername()); %>   sei loggato:   <%out.print(utente.getRuolo()); %>  </div>
    <a href="Base.jsp">Vai</a>


</body>
</html>
