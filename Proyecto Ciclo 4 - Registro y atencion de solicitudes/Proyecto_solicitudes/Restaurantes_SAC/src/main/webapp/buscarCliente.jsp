<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/cliente.css">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Buscar Cliente</h1>
		<form action="clienteSvlt" method="post">
		<input type="hidden" name="opcion" value="buscar">	
			<table>
			<tr>
				<td>Tipo de Documento</td>
				<td>
					<select name="tipoDocumento">
						<option value="-1">Seleccionar</option>
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
					<input id="numero" class="col2" type="text" name="txtNumero" escapeXml="true">
				</td>	
				<td>
					<input type="submit" value="buscar">
				</td>
			</tr>	
			</table>
			<display:table name ="requestScope.listadoCliente" id="clienteList">
				<display:column property="id" title="Codigo de Cliente"/>
				<display:column property="nombres" title="Nombres"/>
				<display:column property="apePaterno" title="Apellido Paterno"/>
				<display:column property="apeMaterno" title="Apellido Materno"/>
				<display:column property="tipoDocumento" title="Tipo de Documento"/>
				<display:column property="idDepartamento" title="Departamento"/>
				<display:column property="idProvincia" title="Provincia"/>
				<display:column property="idDistrito" title="Distrito"/>
				<display:column property="direccion" title="Direccion"/>
				<display:column property="email" title="Correo"/>
				<display:column property="celular" title="Celular"/>
				<display:column title="Actualizar">
						<a href="<%=request.getContextPath()%>/clienteSvlt?opcion=obtener&id=<c:out value="${clienteList.id }" escapeXml="true"/>">Modificar</a>
				</display:column>			
			</display:table>
			
			<div class="lower">
				<p><a href="<%=request.getContextPath()%>/clienteSvlt?opcion=agregar">Registrar</a>
			</div>
			<div class="lower">
				<p><a href="menuAsesor.jsp">Volver al Menu Principal</a>
			</div>
	
		</form>
	</div>
</body>
</html>