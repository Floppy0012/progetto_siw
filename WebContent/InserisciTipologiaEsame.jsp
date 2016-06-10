<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InserisciTipoEsame</title>
</head>
<body ng-app="myapp">

	<div ng-controller="userController">
		<h2>Inserisci la tipologia Esame:</h2>
		<button ng-click="&scope.hacliccato" value="/Controller/prerequisiti.lista">carica
			prerequisiti</button>
		<form action="<c:url value = "/Controller/tipoesame.crea"/>" method="get">
			Nome: <input type="text" name="NomeTipo"><br>
			Descrizione : <input type="text" name="DescrizioneTipo"><br>
			Costo : <input type="float" name="CostoTipo"><br> 
			<input type="submit" name="sumbit" value="invia" />
			
			<div ng-if="&scope.cliccato">						
				<c:forEach var="prerequisito" items="${prerequisiti}">
					<input type="Checkbox" value="si" name="prerequisiti[]">${prerequisito.nome}
				</c:forEach>
				
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		angular.module("myApp", []).controller(
				"userController",
				function($scope) {
					var cliccato= false;
					
					$scope.hacliccato= function(){
						cliccato=true;
					}
				});
	</script>
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</body>
</html>