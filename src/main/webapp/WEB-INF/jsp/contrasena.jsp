<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8"
	import="com.avengers.proyecto.loginController"%>
<!DOCTYPE html>
<html>
<head>
<script src=" https://code.jquery.com/jquery.js ">
	
</script>
<script
	src=" https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet" href="css/estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<title>Cambiar contraseña</title>
</head>
<style>
.boton-salir {
	text-decoration: none;
	font-weight: 600;
	font-size: 20px;
	color: white;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: red;
	border-color: #d8d8d8;
	border-width: 3px;
	border-style: solid;
	border-radius: 35px;
}

.boton-contrasena {
	text-decoration: none;
	font-weight: 600;
	font-size: 20px;
	color: white;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: green;
	border-color: #d8d8d8;
	border-width: 3px;
	border-style: solid;
	border-radius: 35px;
}

.caja {
	font-family: sans-serif;
	font-size: 18px;
	font-weight: 400;
	color: #ffffff;
	background: #ffffff;
	margin: 10 10 25px;
	overflow: hidden;
	padding: 20px;
}
</style>
<body>
	<h2 style="padding-center: 20px;" align="center">Cambio de
		contraseña</h2>

	<p align="center">
		<li type="disc" align="center">Introduzca la contraseña actual</li>
		<li type="disc" align="center">Introduzca la nueva contraseña.
			Esta debe contener al menos 8 caracteres con una mayúscula, una
			minúscula y un número</li>
		<li type="disc" align="center">Vuelva a introducir la nueva
			contraseña</li>



	</p>

	<form action="cambiarContrasena.htm" method="post">
		<p align="center">
			<input type="password" name="inputContrasena"
				placeholder="Contraseña actual" required autofocus> <input
				type="password" name="inputContrasenaNueva1"
				placeholder="Nueva contraseña" required> <input
				type="password" name="inputContrasenaNueva2"
				placeholder="Repetir nueva contraseña" required>
		</p>

		<input class="btn boton-contrasena" type="submit"
			name="cambioContrasena" value="Cambiar Contraseña" />

		<h4 align="center">
			Estado:
			<c:out value="${mensaje}" />
		</h4>
	</form>

	<p>
	<form action="atras.htm" method="post">
		<input class="btn boton-salir" type="submit" value="Atrás">
	</form>
	</p>

	<!--  
	<form action="home.htm" method="post">
			<input class="btn btn-success" type="submit" name="atras"
				value="Atrás" />
	</form>
	-->

	<script>
		function retroceder() {
			window.location.href = "home.htm"
		}
	</script>
</body>
</html>