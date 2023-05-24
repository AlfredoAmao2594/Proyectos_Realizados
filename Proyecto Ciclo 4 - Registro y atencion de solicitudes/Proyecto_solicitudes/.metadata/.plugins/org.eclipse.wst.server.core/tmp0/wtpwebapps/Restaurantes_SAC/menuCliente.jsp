<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/menu.css	">
<title>Insert title here</title>
</head>
<body>
	<form>
		<div id="opcionMenu">
			<h3>Registrar Solicitud</h3>
			<p><a href="<%=request.getContextPath()%>/solicitudSvlt?opcion=listadoData">Registrarse</a>
		</div>
		<div id="opcionMenu">
			<h3>Promociones</h3>
			<p><a href="#">Ver Promociones</a>
		</div>
		<div id="opcionMenu">
			<h3>Actualizar Datos</h3>
			<p><a href="#">Actualizar</a>
		</div>	
	</form>
</body>
</html>