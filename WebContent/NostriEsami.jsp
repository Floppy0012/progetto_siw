<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esami</title>
</head>

<body>
	<ul>
		<c:forEach var="tipoesame" items="${tipoesami}">
			<li><a href="<c:url value="/controller/tipoesame.get?id=${tipoesame.id}"/>">${tipoesame.nome}</a></li>
		</c:forEach>
	</ul>
	
</body>
</html>