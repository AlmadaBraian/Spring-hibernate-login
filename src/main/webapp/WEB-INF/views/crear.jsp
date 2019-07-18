<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/signin/">
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Usuario</title>
	<link href="resources/css/estilo.css" rel="stylesheet" type="text/css">
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<meta name= "viewport" content="width=devicewith, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
<div class="fondo" >
	<div class="container well" id="containerTitle">
		<center><h1>Crear Usuario</h1></center>
		</div>

	
	
	<form action="save" method="post" modelAttribute="usuario">
	<div class="container well" id="containerSingIn">
	<input type="hidden" value="save">

			<center><h2 class="form-signin-heading">Registrate</h2></center>
        	<label for="inputText" class="sr-only">Nombre Usuario</label>
        	<input type="text" name="nombreUsuario" id="formulario" class="form-control" placeholder="Nombre Usuario" required autofocus>

        	<label for="inputPassword" class="sr-only">Contraseña</label>
        	<input type="password" name="contrasenia" id="formulario" class="form-control" placeholder="Contraseña" required>
        	
			<label for="inputEmail" class="sr-only">Email address</label>
        
			<input type="email" name="correo" id="formulario" class="form-control" placeholder="Correo" required>
  
        	<label for="inputText" class="sr-only">Nombre</label>
        	<input type="text" name="nombre" id="formulario" class="form-control" placeholder="Nombre" required>
        	<label for="inputText" class="sr-only">Apellido</label>
        	<input type="text" name="apellido" id="formulario" class="form-control" placeholder="Apellido" required>

		 <button class="btn btn-lg btn-primary btn-block" id="save">Guardar</button>
		</div>
	</form>
</div>
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>