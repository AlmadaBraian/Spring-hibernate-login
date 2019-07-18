<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix = "s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entraste</title>
<meta name= "viewport" content="width=devicewith, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>
 	<form action="logout" method="get">
	<input type="hidden" value="logout">
 <div class="container well">

	<h1><center>Hola ${usuario.nombreUsuario} tu acceso fue exitoso</h1></center>
	</div>
	<div class="container well"  id="containerLogin">
	 <button class="btn btn-lg btn-primary btn-block" name="btn_salir">Salir</button>
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
