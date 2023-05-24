package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DepartamentoDTO;
import beans.DistritoDTO;
import beans.DocumentoDTO;
import beans.ProvinciaDTO;
import beans.SolicitudDTO;
import service.GestionDepartamento;
import service.GestionDistrito;
import service.GestionDocumento;
import service.GestionProvincia;
import service.GestionSolicitud;
import service.GestionUsuario;

/**
 * Servlet implementation class solicitudSvlt
 */
@WebServlet("/solicitudSvlt")
public class solicitudSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public solicitudSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		opcion = (opcion == null ? "error" : opcion);
		if(opcion.equals("obtener")) {
			obtenerSolicitud(request, response);
		}if(opcion.equals("listado")) {
			listadoSolicitudes(request, response);
		}if(opcion.equals("listadoData")) {
			listadoData(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		opcion = (opcion == null ? "error" : opcion);
		System.out.println("Opcion seleccionada es "+opcion);
		if(opcion.equals("registrar")) {
			agregarSolicitud(request,response);
		}else if(opcion.equals("actualizar")) {
			actualizarSolicitud(request, response);
		}
	}
	
	protected void agregarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	SolicitudDTO objSolicitud = new SolicitudDTO();
	int cantidad = 0;
	GestionSolicitud objGestionSolicitud = new GestionSolicitud();
	objSolicitud.setId(Integer.parseInt(request.getParameter("txtIdSolicitud")));
	objSolicitud.setTipoDocumento(Integer.parseInt(request.getParameter("idDocumento")));
	objSolicitud.setNumeroDocumento(request.getParameter("txtNumeroDoc"));
	objSolicitud.setNombres(request.getParameter("txtNombres"));
	objSolicitud.setApePaterno(request.getParameter("txtApellidoPat"));
	objSolicitud.setApeMaterno(request.getParameter("txtApellidoMat"));
	objSolicitud.setTelefono(request.getParameter("txtTelefono"));
	objSolicitud.setCelular(request.getParameter("txtCelular"));
	objSolicitud.setCorreo(request.getParameter("txtCorreo"));
	objSolicitud.setDepartamento(Integer.parseInt(request.getParameter("departamento")));
	objSolicitud.setProvincia(Integer.parseInt(request.getParameter("provincia")));
	objSolicitud.setDistrito(Integer.parseInt(request.getParameter("distrito")));
	objSolicitud.setDireccion(request.getParameter("txtDireccion"));
	objSolicitud.setTipoSolicitud(request.getParameter("tipoSolicitud"));
	objSolicitud.setTipoMotivo(request.getParameter("txtMotivo"));
	objSolicitud.setFechaSolicitud(request.getParameter("txtFechaSol"));
	objSolicitud.setFechaComprobante(request.getParameter("txtFechaComp"));
	objSolicitud.setTipoComprobante(request.getParameter("comprobante"));
	objSolicitud.setNumeroComprobante(request.getParameter("txtNumeroComp"));
	objSolicitud.setTienda(request.getParameter("tienda"));
	objSolicitud.setServicio(request.getParameter("servicio"));
	objSolicitud.setDescripcionSolicitud(request.getParameter("descripcion"));
	objSolicitud.setRespuestaSolicitud("");
	objSolicitud.setEstado("pendiente");
	
	cantidad = objGestionSolicitud.agregarSolicitud(objSolicitud);
	if(cantidad>0) {
		request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
	}
	else{
		request.setAttribute("mensaje", "No se pudieron ingresar los datos");
	}
	request.getRequestDispatcher("/registrarSolicitud.jsp").forward(request,response);	
	
	}
	
	protected void listadoSolicitudes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionSolicitud gss = new GestionSolicitud();
		ArrayList<SolicitudDTO>listadoSolicitud = gss.listadoSolicitud();
		request.setAttribute("listaSolicitud", listadoSolicitud);
		request.getRequestDispatcher("consultaSolicitud.jsp").forward(request, response);
	}
	
	protected void obtenerSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionSolicitud gss = new GestionSolicitud();
		
		SolicitudDTO obSolicitud = gss.obtenerSolicitud(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("objSolicitud", obSolicitud);
		request.getRequestDispatcher("modificarSolicitud.jsp").forward(request, response);
	}
	
	protected void actualizarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionSolicitud gss = new GestionSolicitud();
		SolicitudDTO objSolicitud = new SolicitudDTO();
		objSolicitud.setId(Integer.parseInt(request.getParameter("txtIdSolicitud")));
		objSolicitud.setTipoDocumento(Integer.parseInt(request.getParameter("idDocumento")));
		objSolicitud.setNumeroDocumento(request.getParameter("txtNumeroDoc"));
		objSolicitud.setNombres(request.getParameter("txtNombres"));
		objSolicitud.setApePaterno(request.getParameter("txtApellidoPat"));
		objSolicitud.setApeMaterno(request.getParameter("txtApellidoMat"));
		objSolicitud.setTelefono(request.getParameter("txtTelefono"));
		objSolicitud.setCelular(request.getParameter("txtCelular"));
		objSolicitud.setCorreo(request.getParameter("txtCorreo"));
		objSolicitud.setDepartamento(Integer.parseInt(request.getParameter("departamento")));
		objSolicitud.setProvincia(Integer.parseInt(request.getParameter("provincia")));
		objSolicitud.setDistrito(Integer.parseInt(request.getParameter("distrito")));
		objSolicitud.setDireccion(request.getParameter("txtDireccion"));
		objSolicitud.setTipoSolicitud(request.getParameter("tipoSolicitud"));
		objSolicitud.setTipoMotivo(request.getParameter("txtMotivo"));
		objSolicitud.setFechaSolicitud(request.getParameter("txtFechaSol"));
		objSolicitud.setFechaComprobante(request.getParameter("txtFechaComp"));
		objSolicitud.setTipoComprobante(request.getParameter("txtTipoComp"));
		objSolicitud.setNumeroComprobante(request.getParameter("txtNumeroComp"));
		objSolicitud.setTienda(request.getParameter("txtTienda"));
		objSolicitud.setServicio(request.getParameter("servicio"));
		objSolicitud.setDescripcionSolicitud(request.getParameter("descripcion"));
		objSolicitud.setRespuestaSolicitud(request.getParameter("respuesta"));
		objSolicitud.setEstado("atendido");
		
		int cantidad = gss.modificarSolicitud(objSolicitud);
		if(cantidad > 0) {
			listadoSolicitudes(request, response);
			request.getRequestDispatcher("consultaSolicitud.jsp").forward(request, response);
		}
	}
	
	protected void listadoData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionDocumento gsd = new GestionDocumento();
		GestionDepartamento gsde = new GestionDepartamento();
		GestionProvincia gsp = new GestionProvincia();
		GestionDistrito gsdis = new GestionDistrito();
		ArrayList<DocumentoDTO>listadoDocumento = gsd.listadoDocumento();
		ArrayList<DepartamentoDTO>listadoDepartamento = gsde.listadoDepartamento();
		ArrayList<ProvinciaDTO>listadoProvincia = gsp.listadoProvincia();
		ArrayList<DistritoDTO>listadoDistrito = gsdis.listadoDistrito();
		request.setAttribute("listadoDocumento", listadoDocumento);
		request.setAttribute("listadoDepartamento", listadoDepartamento);
		request.setAttribute("listadoProvincia", listadoProvincia);
		request.setAttribute("listadoDistrito", listadoDistrito);
		request.getRequestDispatcher("/registrarSolicitud.jsp").forward(request,response);
	}
}
