<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esami</title>
</head>

<body>
<link rel="import" id="testa" href="Base.jsp">
	<ul>
		<c:forEach var="tipoesame" items="${tipoesami}">
			<li><a href="<c:url value="/controller/tipoesame.get?id=${tipoesame.id}"/>">${tipoesame.nome}</a></li>
		</c:forEach>
	</ul>
	
		<script type="text/javascript">
var getImport = document.querySelector('#testa');
var getContent = getImport.import.querySelector('#content');
document.body.appendChild(document.importNode(getContent, true));
</script>
</body>
</html>