<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/solicitud.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de Solicitudes</h1>
		<form action="solicitudSvlt" method="post">
		<input type="hidden" name="opcion" value="listado">
		<display:table name="requestScope.listaSolicitud" pagesize ="10" id="listSolicitud">
			<display:column property="id" title="Numero de solicitud"/>
			<display:column property="tipoDocumento" title="Tipo de Documento"/>
			<display:column property="numeroDocumento" title="Numero de Documento"/>
			<display:column property="nombres" title="Nombres"/>
			<display:column property="apePaterno" title="Apellido Paterno"/>
			<display:column property="apeMaterno" title="Apellido Materno"/>
			<display:column property="tipoSolicitud" title="Tipo de Solicitud"/>
			<display:column property="fechaSolicitud" title="Fecha de Solicitud"/>
			<display:column property="estado" title="Estado"/>
			<display:column title="Atender">
					<a href="<%=request.getContextPath()%>/solicitudSvlt?opcion=obtener&id=<c:out value="${listSolicitud.id }" escapeXml="true"/>">Modificar</a>
			</display:column>
		</display:table>
			<div class="lower">
				<p><a href="menuAsesor.jsp">Volver al Menu Principal</a>
			</div>	
		</form>
		
</body>
</html>