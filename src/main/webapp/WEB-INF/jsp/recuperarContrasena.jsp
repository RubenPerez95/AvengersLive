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
<title>Recuperar contraseña</title>
</head>
<body>
	<h2 style="padding-center: 20px;" align="center">Recuperar Contraseña</h2>



	<form action="enviarPeticionContrasena.htm" method="post">
		<p align="center">
			<span></span>
			<input type="text" name="inputEmail"
				placeholder="Email" required autofocus>
		</p>

		<input class="btn btn-success" type="submit" name="enviarPeticion"
			value="Recuperar contraseña" />
		
		<h4 align="center">
			Estado:
			<c:out value="${mensaje}" />
		</h4>
	</form>
	
	<!--  
	<form action="home.htm" method="post">
			<input class="btn btn-success" type="submit" name="atras"
				value="Atrás" />
	</form>
	-->

</body>
</html>