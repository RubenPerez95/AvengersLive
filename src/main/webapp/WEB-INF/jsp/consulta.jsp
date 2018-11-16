<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src=" https://code.jquery.com/jquery.js">	
</script>
<script
	src=" https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet"
	href=" https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estilos.css">
<title>Consulta Fichajes</title>
</head>
<style>
html, body {
	height: 100%;
	width: 100%;
	margin: 0;
	display: flex;
	flex-direction: column;
	flex-wrap: wrap;
}

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

tr:hover {
	background-color: #D5D5D5;
}

table {
	font-size: 15px;
	width: 50%;
	height: 150px;
	text-align: center;
}

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
</style>
<body>
	<p>
	<h2 align="center">Listado de fichajes</h2>
	</p>
	<p>
	<form action="consulta.htm" method="post">
		<table align="center" border="1"width: 100%>
			<thead bgcolor="#FFFD86">
				<tr>
					<th>Fecha</th>
					<th>Apertura</th>
					<th>Cierre</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody bgcolor="#FFD27D">
				<c:forEach var="fich" items="${fichajes}">
					<tr>
						<td>${fich.fechaFichaje}</td>
						<td>${fich.horaEntrada}</td>
						<td>${fich.horaCierre}</td>
						<td>${fich.estado}</td>
				</c:forEach>
			</tbody>
		</table>
	</form>
	</p>

	<p>
		<input class="btn boton-salir" type="button" value="Atrás"
			onclick="history.back()">
	</p>

</body>
</html>