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
%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crea Esame</title>
</head>
<body>
<form action = "<c:url value = "/controller/prenotazione.crea"/>" method = "get">
<div>${CodiceFiscaleError}</div>
Codice Fiscale: <input type = "text" name = "CodiceFiscale" value = "${param.CodiceFiscale}">
<input type = "submit" name="submit" value="Invia"/>
</form>
<div>${TipoEsameError}</div>
</body>
</html>