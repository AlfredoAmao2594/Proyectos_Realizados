<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/comprobante.css">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Buscar Comprobante de Pago</h1>
		<form action="comprobanteSvlt" method="post">
			<input type="hidden" name="opcion" value="buscar">			
			<table>
			<tr>
				<td>Tipo de Comprobante</td>
				<td>
					<select name="idComprobante">
						<option value="-1">Seleccionar</option>
						<option value="factura">Factura</option>
						<option value="boleta">Boleta</option>
					</select>
				</td>
				<td></td>
				<td>Numero de Comprobante</td>
				<td>
					<input id="numeroCom" class="col2" type="text" name="txtNumeroCom" value="${objSolicitud.numeroCom }" escapeXml="true">
				</td>	
				<td>
					<input type="submit" value="buscar">
				</td>
			</tr>	
			</table>
			<display:table name ="requestScope.listadoComprobante" id="comprobante">
				<display:column property="tipo" title="Tipo de Comprobante"/>
				<display:column property="numero" title="Numero de Comprobante"/>
				<display:column property="fecha" title="Fecha Comprobante"/>
				<display:column property="nombres" title="Nombres"/>
				<display:column property="apellidos" title="Apellidos"/>
				<display:column property="tipoDocumento" title="Tipo de Documento"/>
				<display:column property="numeroDocumento" title="Numero de Documento"/>
				<display:column property="importe" title="Importe"/>
				<display:column property="estado" title="Estado"/>
			</display:table>
			
			<div class="lower">
				<p><a href="menuAsesor.jsp">Volver al Menu Principal</a>
			</div>
			
		
		</form>
	</div>
</body>
</html>