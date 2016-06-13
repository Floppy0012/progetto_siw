<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tipologia esamoe</title>
</head>
<body>
	<h1>${tipoesame.nome}</h1>
	<h2>specifiche:</h2>
	<div>Costo: ${tipoesame.costo}</div>
	<div>Descrizione: ${tipoesame.descrizione}</div>
	
	 <c:if test="${tipoesame.prerequisiti}!= null">
		 <div>
			<ul>		
				<c:forEach var="prerequisito" items="${tipoesame.prerequisiti}">
					<li>${prerequisito.descrizione}</li>
				</c:forEach>
			</ul>		
		</div> 
	</c:if>
</body>
</html>