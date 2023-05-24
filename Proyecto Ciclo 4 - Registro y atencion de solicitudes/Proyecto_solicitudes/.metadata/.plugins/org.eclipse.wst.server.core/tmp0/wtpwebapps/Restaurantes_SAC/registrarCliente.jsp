<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/cliente.css">
<title>Insert title here</title>
</head>
<body>
<div>
		<h1>Registrar Cliente</h1>
			<form action="clienteSvlt" method="post">
				<input type="hidden" name="opcion" value="registrar">
					<table>
						<tr>
							<td>Id de Cliente</td>
							<td>
								<input type="text" name="id" required="required" value="<c:out value="${objCliente.id }" escapeXml="true"/>">
							</td>
						</tr>
						<tr>
							<td>Nombres</td>
							<td>
								<input type="text" name="nombres" value="<c:out value="${objCliente.nombres }" escapeXml="true"/>">
							</td>
						</tr>
						<tr>
							<td>Apellido Paterno</td>
							<td>
								<input type="text" name="apePaterno" value="<c:out value="${objCliente.apePaterno }" escapeXml="true"/>">
							</td>
							<td>Apellido Materno</td>
							<td>
								<input type="text" name="apeMaterno" value="<c:out value="${objCliente.apeMaterno }" escapeXml="true"/>">
							</td>
						</tr>
						<tr>
							<td>Tipo de Documento</td>
							<td>
								<select name="tipoDocumento">
									<c:forEach var="objDocumento" items="${requestScope.listadoDocumento }">
										<option value="<c:out value="${objDocumento.tipoDocumento }" escapeXml="true"/>">
											<c:out value="${objDocumento.desDocumento }" escapeXml="true"/>
										</option>
									</c:forEach>
								</select>
							</td>
							<td></td>
							<td>Numero de Documento</td>
							<td>
								<input type="text" name="numeroDocumento" value="<c:out value="${objCliente.numero }" escapeXml="true"/>">
							</td>
						</tr>
						<tr>
							<td>Departamento</td>
							<td>
								<select name="departamento">
									<c:forEach var="objDepartamento" items="${requestScope.listadoDepartamento }">
										<option value="<c:out value="${objDepartamento.id }" escapeXml="true"/>">
											<c:out value="${objDepartamento.descripcion }" escapeXml="true"/>
										</option>
									</c:forEach>
								</select>
							</td>
							<td>Provincia</td>
							<td>
								<select name="provincia">
									<c:forEach var="objProvincia" items="${requestScope.listadoProvincia }">
										<option value="<c:out value="${objProvincia.id }" escapeXml="true"/>">
											<c:out value="${objProvincia.descripcion }" escapeXml="true"/>
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>Distrito</td>
							<td>
								<select name="distrito">
									<c:forEach var="objDistrito" items="${requestScope.listadoDistrito }">
										<option value="<c:out value="${objDistrito.id }" escapeXml="true"/>">
											<c:out value="${objDistrito.descripcion }" escapeXml="true"/>
										</option>
									</c:forEach>
								</select>
							</td>
							<td>Direccion</td>
							<td>
								<input type="text" name="direccion" value="<c:out value="${objCliente.direccion }" escapeXml="true"/>">
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>
								<input type="text" name="email" value="<c:out value="${objCliente.email }" escapeXml="true"/>">
							</td>
							<td>Celular</td>
							<td>
								<input type="text" name="celular" value="<c:out value="${objCliente.celular }" escapeXml="true"/>">
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr id="btnAccion">
							<td></td>
							<td></td>
							<td align="center"><input type="submit" value="Registrar" class="boton"></td>
						</tr>
						
					</table>
						<div class="lower" id="opcionMenu">
							<p><a href="<%=request.getContextPath()%>/clienteSvlt?opcion=listado">Volver a Buscar Cliente</a>
						</div>
		</form>
	</div>
</body>
</html>