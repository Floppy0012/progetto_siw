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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>visualizza esami medico</title>
</head>
<body>
<form action="<c:url value = "/controller/medico.cerca"/>" method="get">
	<div>${nomeError}</div>
	Nome medico <input type="text" name="nome">
	<div>${cognomeError}</div>
	Cognome medico <input type="text" name="cognome">
	<input type="submit" name="sumbit" value="invia" />
</form>
<ul>
		<c:forEach var="esame" items="${esami}">
		<li>codice esame ${esame.medico} è stateffettoato il giorno ${esame.DataEffettuazione}</li>	 
		</c:forEach>
		</ul>
</body>
</html>