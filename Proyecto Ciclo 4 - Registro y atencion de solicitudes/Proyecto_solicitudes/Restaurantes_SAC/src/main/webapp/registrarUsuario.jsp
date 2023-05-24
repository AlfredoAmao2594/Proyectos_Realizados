<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/usuario.css">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	<form id="frmRegistro" method="post" action="usuarioSvlt">	
		<input type="hidden" name="opcion" value="registrar">
		<h1>Registro de Usuario</h1>
			<table >
				
					<tr align="left">
						<td class="col">Nombre</td>
						<td ><input class="col2" type="text" name="txtNombre" size="30"  required="required"></td>
					</tr>
					<tr align="left">
						<td class="col">Apellido Paterno</td>
						<td><input class="col2" type="text" name="txtApePaterno" size="30"></td>
						<td class="col">Apellido Materno</td>
						<td><input class="col2" type="text" name="txtApeMaterno" size="30"></td>
					</tr>
					<tr align="left">
						<td class="col">Tipo de Documento</td>
						<td >
							<select class="col4" name="tipoDocumento">
								<c:forEach var="objDocumento" items="${requestScope.listadoDocumento }">
									<option value="<c:out value="${objDocumento.tipoDocumento }" escapeXml="true"/>">
										<c:out value="${objDocumento.desDocumento }" escapeXml="true"/>
									</option>
								</c:forEach>
							</select>
						</td>
						<td class="col">Numero de Documento</td>
						<td><input class="col2" type="text" name="txtNumeroDocumento" size="30"></td>
					</tr>
					<tr>
						<td class="col">Nombre de Usuario</td>
						<td><input class="col2" type="text" name="txtUsuario" size="30"></td>
						<td class="col">Contraseña</td>
						<td><input class="col2" type="text" name="txtContrasenia" size="30"></td>					
					</tr>
					<tr>
						<td class="col">Tipo de Usuario</td>
						<td >
							<select class="col4"name="txtTipoUsuario">
								<option value="cliente">Cliente</option>
								<option value="asesor">Asesor</option>
							</select>
						</td>
					</tr>
				</table>
			<div id="lower">
				<input type="submit" value="registrar">
				<p><a href="login.jsp">Volver al Login</a>
			</div>
		</form>
	</div>
</body>
</html>