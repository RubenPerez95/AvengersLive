<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/estilos.css">
<title>Home</title>
</head>
<body>
	<h1 align="center">Bienvenido a AvengersLive Web</h1>
	<h2 align="right">
		Usuario:
		<c:out value="${email}" />
	</h2>
	</br>
	<div class="card card-container">		
		<form action="home.htm" method="post" class="form-signin">
			<center>
				<button class="btn btn-lg btn-primary btn-block btn-signin"><b>Abrir
					fichaje</b></button>
				<button class="btn btn-lg btn-primary btn-block btn-signin"><b>Cerrar
					fichaje</b></button>
			</center>
		</form>
	</div>
</body>
</html>
