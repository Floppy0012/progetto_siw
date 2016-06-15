<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Circe-Clinica</title>
<!-- Fogli di stile -->
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="js/modernizr.custom.js"></script>
<script type="text/javascript">
function cambia(pagina){
   var frame;
   if(document.getElementById) frame = document.getElementById('pageFrame');
   else frame = document.all['pageFrame'];
   frame.src = pagina;
}
</script>

</head>
<body>
	<header id="content">
		<div>
			<h1 align="center">
				<a href="Base.jsp">CIRCE<small> Clinica privata</small></a>
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

						<li><a href="<c:url value = "/controller/tipoesame.list"/>">
								esamina i nostri esami </a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" onclick="cambia('Login.jsp');">LOGIN</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Amministratore <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#" onclick="cambia('InserisciTipologiaEsame.jsp');">
										Inserisci una nuova tipologia d'esame</a></li>
								<li><a href="#" onclick="cambia('Esamimedico.jsp');">Visualizza
										esami del medico: </a></li>
								<li><a href="#" onclick="cambia('CreazioneEsamePrenotato.jsp');">Effettua
										Prenotazione</a></li>
							</ul></li>
							
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Paziente: <span
								class="glyphicon glyphicon-lock" aria-hidden="true"></span> <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li class="disabled">Prenotati</a></li>
								<li class="disabled">Effettuati</a></li>
								<li  class="disabled">Risultati</a></li>
								<li role="separator" class="divider"></li>
								<li  class="disabled">i tuoi dati personali</a></li>
							</ul></li>


					</ul>
				</div>

			</div>

		</nav>
	</header>
	<div class="row">
	<div class="col-sm-12 col-lg-12">
	<iframe id="pageFrame" scrolling="no" frameborder="0" height=1000 width=100% ></iframe>
	</div>
	</div>
	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>