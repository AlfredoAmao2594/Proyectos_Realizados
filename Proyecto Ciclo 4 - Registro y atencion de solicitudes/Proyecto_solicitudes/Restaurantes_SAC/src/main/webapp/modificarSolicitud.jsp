<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/ventana2.css	">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<form action="solicitudSvlt" method="post">
		<input type="hidden" name="opcion" value="actualizar">
			<h1>Atencion de Solicitud</h1>
			<table>
				<tr>
					<td class="col">Tipo de Documento</td>
					<td>
						<input class="col2" type="text" name="idDocumento" required="required" readonly="readonly" value="${objSolicitud.tipoDocumento }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Numero de Documento</td>
					<td>
						<input class="col2" type="text" name="txtNumeroDoc" required="required" readonly="readonly"  value="${objSolicitud.numeroDocumento }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Nombres</td>
					<td colspan="5">
						<input id="nombre" class="col2" type="text" name="txtNombres" required="required" readonly="readonly"  value="${objSolicitud.nombres }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Apellido Paterno</td>
					<td>
						<input class="col2" type="text" name="txtApellidoPat" required="required" readonly="readonly"  value="${objSolicitud.apePaterno }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Apellido Materno</td>
					<td>
						<input class="col2" type="text" name="txtApellidoMat" required="required" readonly="readonly"  value="${objSolicitud.apeMaterno }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Telefono</td>
					<td>
						<input class="col2" type="text" name="txtTelefono" required="required" readonly="readonly"  value="${objSolicitud.telefono }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Celular</td>
					<td>
						<input class="col2" type="text" name="txtCelular" required="required" readonly="readonly"  value="${objSolicitud.celular }" escapeXml="true">
					</td>				
				</tr>
				<tr>
					<td class="col">Correo Electrónico</td>
					<td >
						<input class="col2" type="text" name="txtCorreo" required="required" readonly="readonly"  value="${objSolicitud.correo }" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Departamento</td>
					<td>
						<input class="col2" type="text" name="departamento" required="required" readonly="readonly"  value="${objSolicitud.departamento }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Provincia</td>
					<td>
						<input class="col2" type="text" name="provincia" required="required" readonly="readonly"  value="${objSolicitud.provincia }" escapeXml="true">
					</td>	
				</tr>
				<tr>
					<td class="col">Distrito</td>
					<td >
						<input class="col2" type="text" name="distrito" required="required" readonly="readonly"  value="${objSolicitud.distrito }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Direccion</td>
					<td >
						<input class="col2" type="text" name="txtDireccion" required="required" readonly="readonly"  value="${objSolicitud.direccion }" escapeXml="true">
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td class="col">Numero de Solicitud</td>
					<td>
						<input class="col2" type="text" name="txtIdSolicitud" required="required" readonly="readonly"  value="${objSolicitud.id }" escapeXml="true" >
					</td>
					<td></td>
					<td class="col">Tipo de Solicitud</td>
					<td>
						<input class="col2" type="text" name="tipoSolicitud"" required="required" readonly="readonly"  value="${objSolicitud.tipoSolicitud }" escapeXml="true">
					</td>
				</tr>			
				<tr>
					<td class="col">Motivo</td>
					<td>
						<input class="col2" type="text" name="txtMotivo" required="required" readonly="readonly"  value="${objSolicitud.tipoMotivo }" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Fecha de Solicitud</td>
					<td>
						<input class="col2" type="text" name="txtFechaSol" required="required" readonly="readonly"  value="${objSolicitud.fechaSolicitud }" escapeXml="true" >
					</td>
				</tr>
				<tr>
					<td class="col">Fecha de Comprobante</td>
					<td>
						<input class="col2" type="text" name="txtFechaComp" required="required" readonly="readonly"  value="${objSolicitud.fechaComprobante}" escapeXml="true">
					</td>
					<td></td>
					<td class="col">Tienda</td>
					<td>
						<input class="col2" type="text" name="txtTienda" required="required" readonly="readonly"  value="${objSolicitud.tienda}" escapeXml="true">							
					</td>
				</tr>
				<tr>
					<td class="col">Tipo de Comprobante</td>
					<td>
						<input class="col2" type="text" name="txtTipoComp" required="required" readonly="readonly"  value="${objSolicitud.tipoComprobante}" escapeXml="true">	
					</td>
					<td></td>
					<td class="col">Numero de Comprobante</td>
					<td>
						<input class="col2" type="text" name="txtNumeroComp" required="required" readonly="readonly"  value="${objSolicitud.numeroComprobante}" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Servicio Realizado</td>
				</tr>
				<tr>
					<td colspan="5">
						<input id="servicio" class="col2"  type="text" name="servicio" required="required" readonly="readonly"  value="${objSolicitud.servicio}" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Descripcion de Solicitud</td>
				</tr>
				<tr>
					<td colspan="5">
						<input id="descripcion" class="col2"  type="text" name="descripcion" required="required" readonly="readonly"  value="${objSolicitud.descripcionSolicitud}" escapeXml="true">
					</td>
				</tr>
				<tr>
					<td class="col">Respuesta de Solicitud</td>
				</tr>
				<tr>
					<td colspan="5" >
						<textarea class="col3" name="respuesta" rows="10" cols="100" value="${objSolicitud.respuestaSolicitud }"></textarea>
					</td>
				</tr>
			</table>
			<div id="lower">
				<input type="submit" value="actualizar">
				<p><a href="<%=request.getContextPath()%>/solicitudSvlt?opcion=listado">Volver al Listado</a>
			</div>	
		</form>
	</div>
</body>
</html>