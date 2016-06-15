<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Circe-Clinica</title>
<!-- Fogli di stile -->
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="js/modernizr.custom.js"></script>

</head>
<body>

	<header id="content">
		<div>
			<h1 align="center">
				<a href="base.html">CIRCE<small> Clinica privata</small></a>
			</h1>

		</div>

		<nav class="navbar navbar-default navbar-static-top">
			<div class="container-fluid">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand <span
						class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Chi Siamo <span
								class="sr-only">(current)</span></a></li>
						<li><a href="#">Dove Siamo <span
								class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Amministratore <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="<c:url value = "/InserisciTipologiaEsame.jsp"/>">
										Inserisci una nuova tipologia d'esame</a></li>
								<li><a href="<c:url value = "/Esamimedico.jsp"/>">Visualizza esami del medico: </a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
									<li><a href="<c:url value = "/controller/tipoesame.list"/>"> esamina i nostri esami </a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">I Tuoi Esami: <span
								class="glyphicon glyphicon-lock" aria-hidden="true"></span> <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Prenotati</a></li>
								<li><a href="#">Effettuati</a></li>
								<li><a href="#">Risultati</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">i tuoi dati personali</a></li>
							</ul></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="Login.jsp">LOGIN</a></li>


					</ul>
				</div>

			</div>

		</nav>
	</header>


	<script language=”javaScript”>
		document.write(footer);
	</script>
	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>