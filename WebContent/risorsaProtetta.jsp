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
	   RequestDispatcher rd = application.getRequestDispatcher("/fallimento.jsp");
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
    <div> CIAO, <%out.print(utente.getUsername());%> SEI LOGGATO COME: <%out.print(utente.getRuolo());%> </div>


</body>
</html>
