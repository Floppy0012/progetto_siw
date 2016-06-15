<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.uniroma3.siw_progetto.model.Utente"%>
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
<title>InserisciTipoEsame</title>
</head>
<body>


	<div>
		<h2>Inserisci la tipologia Esame:</h2>

		<form action="<c:url value = "/controller/tipoesame.crea"/>"
			method="get">

			<div>${nomeError}</div>
			<div>
				Nome: <input type="text" name="NomeTipo" value="${param.NomeTipo}">
			</div>

			<div>${costoError}</div>
			<div>
				Costo : <input type="float" name="CostoTipo"
					value="${param.CostoTipo}">
			</div>

			<div>${descrizioneError}</div>
			<div>
				Descrizione :<input type="text" name="DescrizioneTipo"
					value="${param.DescrizioneTipo}">
			</div>
			<input type="submit" name="sumbit" value="invia" />
		</form>



	</div>

</body>
</html>