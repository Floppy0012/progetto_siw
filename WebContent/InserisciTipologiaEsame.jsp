<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InserisciTipoEsame</title>
</head>
<body>
	<div>
		<h2>Inserisci la tipologia Esame:</h2>
		<form action="ControllerInserimentoTipoEsame" method="get">
			Nome: <input type="text" name="NomeTipo"><br>
			Descrizione : <input type="text" name="DescrizioneTipo"> <input
				type="submit" name="sumbit" value="invia" />
		</form>
	
	</<%-- DANI, QUESTA � LA FORM, UNA VOLTA FATTO INVIO, 
	DOBBIAMO GESTIRLA NEL CONTROLLER 
	E LA DEVE POI INSERIRE NEL DB.  --%>

	</div>
</body>
</html>