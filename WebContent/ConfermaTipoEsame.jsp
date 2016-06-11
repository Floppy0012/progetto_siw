<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONVALIDA INSERIMENTO</title>
</head>
<body>
<div>Hai insrito corretamete i dati</div>

	<div>Nome Esame: ${TipoEsame.NomeTipo}</div>
	<div>Descrizione: ${TipoEsame.DescrizioneTipo}</div>
	<div>Costo: ${TipoEsame.CostoTipo}</div>

<a href="/InserisciTipologiaEsami.jsp">inserisci altri esami</a>
</body>
</html>