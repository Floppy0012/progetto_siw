<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value = "/controller/prerequisiti.inserisci"/>"
		method="get">
		<c:forEach var="prerequisito" items="${prerequisiti}">
			<input type="Checkbox" value="${prerequisito.nome}" name="prerequisiti"> ${prerequisito.nome}<br>
				</c:forEach>
		<input type="submit" name="sumbit" value="invia" />
	</form>
</body>
</html>