<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InserisciTipoEsame</title>
</head>
<body ng-app="myApp">

	<div ng-controller="userController">
		<h2>Inserisci la tipologia Esame:</h2>

		<form action="<c:url value = "/controller/prerequisiti.lista"/>" method="get">
			<button ng-click="&scope.hacliccato()" type="submit">carica prerequisiti</button>
		</form>

		<form action="<c:url value = "/controller/tipoesame.crea"/>" method="get">
			<div>
				Nome: <input type="text" name="NomeTipo" value="${param.NomeTipo}">${nomeError}</div>
			<div>
				Costo : <input type="float" name="CostoTipo"
					value="${param.CostoTipo}">${costoError}</div>
			<div>
				Descrizione :<input type="text" name="DescrizioneTipo"
					value="${param.DescrizioneTipo}"> ${descrizioneError}
			</div>
			<div ng-show="$scope.cliccato1()">
				<c:forEach var="prerequisito" items="${prerequisiti}">
					<input type="Checkbox" value="si" name="prerequisiti[]"> ${prerequisito.nome}
				</c:forEach>
			</div>

			<input type="submit" name="sumbit" value="invia" />
		</form>



	</div>

	<script type="text/javascript">
		angular.module("myApp", []).controller("userController",
				function($scope) {
					var cliccato = false;

					$scope.hacliccato = function() {
						cliccato = true;
					}
					$scope.cliccato1 = function() {
						return cliccato;
					}
				});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</body>
</html>