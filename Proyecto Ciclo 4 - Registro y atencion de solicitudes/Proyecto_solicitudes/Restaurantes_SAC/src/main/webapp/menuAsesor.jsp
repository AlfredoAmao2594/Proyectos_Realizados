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
			<h3>Listado de Solicitudes</h3>
			<p><a href="<%=request.getContextPath()%>/solicitudSvlt?opcion=listado">Listar</a>
		</div>
		<div id="opcionMenu">
			<h3>Consultar Cliente</h3>
			<p><a href="<%=request.getContextPath()%>/clienteSvlt?opcion=listado">Ver Detalle</a>
		</div>
			<div id="opcionMenu">
			<h3>Buscar Comprobante</h3>
			<p><a href="buscarComprobante.jsp">Ver Detalle</a>
		</div>	
	</form>
</body>
</html>