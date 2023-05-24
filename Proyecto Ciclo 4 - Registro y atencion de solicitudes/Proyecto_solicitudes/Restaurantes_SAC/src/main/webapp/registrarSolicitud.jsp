<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%
    String mensaje=(String)request.getAttribute("mensaje");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/ventana.css	">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<form action="solicitudSvlt" method="post">
		<input type="hidden" name="opcion" value="registrar">
			<h1>Registro de Solicitud</h1>
			<table>
				<tr>
					<td class="col">Tipo de Documento</td>
					<td>
						<select class="col4" name="idDocumento">
							<c:forEach var="objDocumento" items="${requestScope.listadoDocumento }">
								<option value="<c:out value="${objDocumento.tipoDocumento }" escapeXml="true"/>">
									<c:out value="${objDocumento.desDocumento }" escapeXml="true"/>
								</option>
							</c:forEach>
						</select>
					</td>
					<td></td>
					<td class="col">Numero de Documento</td>
					<td>
						<input class="col2" type="text" name="txtNumeroDoc" required="required" value="${objSolicitud.numeroDoc }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Nombres</td>
					<td colspan=5>
						<input id="nombre" class="col2" type="text" name="txtNombres" required="required" value="${objSolicitud.nombres }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Apellido Paterno</td>
					<td>
						<input class="col2" type="text" name="txtApellidoPat" required="required" value="${objSolicitud.apellidoPat }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Apellido Materno</td>
					<td>
						<input class="col2" type="text" name="txtApellidoMat" required="required" value="${objSolicitud.apellidoMat }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Telefono</td>
					<td>
						<input class="col2" type="text" name="txtTelefono" required="required" value="${objSolicitud.telefono }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Celular</td>
					<td>
						<input class="col2" type="text" name="txtCelular" required="required" value="${objSolicitud.celular }" escapeXml="true">
					</td>				
				</tr>
				<tr>
					<td class="col">Correo Electrónico</td>
					<td >
						<input class="col2" type="text" name="txtCorreo" required="required" value="${objSolicitud.correo }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Departamento</td>
					<td>
						<select class="col4" name="departamento">
							<c:forEach var="objDepartamento" items="${requestScope.listadoDepartamento }">
								<option value="<c:out value="${objDepartamento.id }" escapeXml="true"/>">
									<c:out value="${objDepartamento.descripcion }" escapeXml="true"/>
								</option>
							</c:forEach>
						</select>
					</td>
					<td></td>
					<td class="col">Provincia</td>
					<td>
						<select class="col4" name="provincia">
							<c:forEach var="objProvincia" items="${requestScope.listadoProvincia }">
								<option value="<c:out value="${objProvincia.id }" escapeXml="true"/>">
									<c:out value="${objProvincia.descripcion }" escapeXml="true"/>
								</option>
							</c:forEach>
						</select>
					</td>	
				</tr>
				<tr>
					<td class="col">Distrito</td>
					<td >
						<select class="col4" name="distrito">
							<c:forEach var="objDistrito" items="${requestScope.listadoDistrito }">
								<option value="<c:out value="${objDistrito.id }" escapeXml="true"/>">
									<c:out value="${objDistrito.descripcion }" escapeXml="true"/>
								</option>
							</c:forEach>
						</select>
					</td>
					<td></td>
					<td class="col">Direccion</td>
					<td >
						<input class="col2" type="text" name="txtDireccion" required="required" value="${objSolicitud.direccion }" escapeXml="true">
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td class="col">Numero de Solicitud</td>
					<td>
						<input class="col2" type="text" name="txtIdSolicitud" required="required" value="${objSolicitud.idSolicitud }" escapeXml="true" >
					</td>
					<td></td>
					<td class="col">Tipo de Solicitud</td>
					<td>
						<select class="col4" name="tipoSolicitud">
							<option value="-1">Selecciona</option>
							<option value="Consultar">Consultar</option>
							<option value="Reclamo">Reclamo</option>
						</select>
					</td>
				</tr>			
				<tr>
					<td class="col">Motivo</td>
					<td>
						<input class="col2" type="text" name="txtMotivo" required="required" value="${objSolicitud.motivo }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Fecha de Solicitud</td>
					<td>
						<input class="col2" type="text" name="txtFechaSol" required="required" value="${objSolicitud.fechaSolicitud }" escapeXml="true" >
					</td>
				</tr>
				<tr>
					<td class="col">Fecha de Comprobante</td>
					<td>
						<input class="col2" type="text" name="txtFechaComp" required="required" value="${objSolicitud.fechaComprobante}" escapeXml="true"">
					</td>
					<td></td>
					<td class="col">Tienda</td>
					<td>
						<select class="col4" name="tienda">
							<option value="-1">Selecciona Tienda</option>
							<option value="Lima">Lima</option>
						</select>						
					</td>
				</tr>
				<tr>
					<td class="col">Tipo de Comprobante</td>
					<td>
						<select class="col4" name="comprobante">
							<option value="-1">Selecciona</option>
							<option value="Factura">Factura</option>
							<option value="Boleta">Boleta</option>
						</select>	
					</td>
					<td></td>
					<td class="col">Numero de Comprobante</td>
					<td>
						<input class="col2" type="text" name="txtNumeroComp" required="required" value="${objSolicitud.numeroComprobante}" escapeXml="true"">
					</td>
				</tr>
				<tr>
					<td class="col">Servicio Realizado</td>
				</tr>
				<tr>
					<td colspan="5">
						<textarea class="col3" name="servicio" rows="10" cols="100" value="${objSolicitud.servicio }"></textarea>
					</td>
				</tr>
				<tr>
					<td class="col">Descripcion de Solicitud</td>
				</tr>
				<tr>
					<td colspan="5">
						<textarea class="col3" name="descripcion" rows="10" cols="100" value="${objSolicitud.descripcion }"></textarea>
					</td>
				</tr>
				<tr align="center">
						<td colspan="2" bgcolor="red">
							<%if(mensaje!=null){ %>
							<%=mensaje%>
							<%} %>
						</td>
						
					</tr>
			</table>
			<div id="lower">
				<input type="submit" value="registrar">
				<p><a href="menuCliente.jsp">Volver al Menu Principal</a>
			</div>	
		</form>
	</div>
</body>
</html>