<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.uniroma3.siw_progetto.model.Utente"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	boolean autorizzato = true;
	if (utente != null)
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
<title>ScegliTipoEsame</title>
</head>
<body>
	<form action="<c:url value = "/controller/esameprenotato.crea"/>" method="get">
		Codice Fiscale : <input type="text" value="${CodiceFiscale}" name="CodiceFiscale"> 
		Nome : <input type="text" value="${nomePaziente}">
		Cognome : <input type="text" value="${cognomePaziente }">
		<fieldset>
			<legend> Tipologia Esami: </legend>
				<c:forEach var="tipoEsame" items="${tipiEsami}">
					<input type="radio" name ="tipiEsami" value="${tipoEsame.nome}"/>${tipoEsame.nome}<br>
				</c:forEach>

		</fieldset>
		<input type="submit" name="submit" value="Invia" />
	</form>
</body>
</html>