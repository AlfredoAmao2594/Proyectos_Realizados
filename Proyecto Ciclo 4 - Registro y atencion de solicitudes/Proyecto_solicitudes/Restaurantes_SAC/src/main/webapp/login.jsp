<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css	">
<title>Insert title here</title>
</head>
<body>
	<form id="frmRegistro" method="post" action="usuarioSvlt">
		<input type="hidden" name="opcion" value="a">
		<div id="container">
			<label for="name">Usuario</label>
			<input type="name" name="txtUsuario">
			<label for="username">Contraseña</label>
			<input type="password" name="txtClave">
			<div id="lower">
				<input type="submit" value="ingresar">
				<p><a href="<%=request.getContextPath()%>/usuarioSvlt?opcion=listado">Registrar Nuevo Usuario</a>
			</div>
	
		</div>
	</form>
</body>
</html>