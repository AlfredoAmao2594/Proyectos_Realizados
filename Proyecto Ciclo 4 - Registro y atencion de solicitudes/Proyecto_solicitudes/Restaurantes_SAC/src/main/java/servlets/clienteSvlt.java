	package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteDTO;
import beans.DepartamentoDTO;
import beans.DistritoDTO;
import beans.DocumentoDTO;
import beans.ProvinciaDTO;
import service.GestionCliente;
import service.GestionDepartamento;
import service.GestionDistrito;
import service.GestionDocumento;
import service.GestionProvincia;

/**
 * Servlet implementation class clienteSvlt
 */
@WebServlet("/clienteSvlt")
public class clienteSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clienteSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		if(opcion.equals("buscar")) {
			buscarCliente(request,response);
		}else if(opcion.equals("listado")) {
			listadoDocumento(request,response);
		}else if(opcion.equals("obtener")) {
			obtenerCliente(request,response);
		}else if(opcion.equals("modificar")){
			actualizarCliente(request,response);
		}else if(opcion.equals("registrar")) {
			registrarCliente(request,response);
		}else if(opcion.equals("agregar")){
			listadoAgregar(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void listadoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionDocumento gsd = new GestionDocumento();
		ArrayList<DocumentoDTO>listarDocumento = gsd.listadoDocumento();
		request.setAttribute("listadoDocumento", listarDocumento);
		request.getRequestDispatcher("/buscarCliente.jsp").forward(request,response);
		
	}
	
	protected void listadoAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		request.getRequestDispatcher("/registrarCliente.jsp").forward(request,response);
	}
	protected void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tipo = Integer.parseInt(request.getParameter("tipoDocumento"));
		String numero = request.getParameter("txtNumero");
		GestionCliente gsp = new GestionCliente();
		GestionDocumento gsd = new GestionDocumento();
		ArrayList<DocumentoDTO>listarDocumento = gsd.listadoDocumento();
		ArrayList<ClienteDTO>listadoCliente = gsp.listarClienteFiltro(tipo, numero);
		request.setAttribute("listadoCliente", listadoCliente);
		request.setAttribute("listadoDocumento", listarDocumento);
		request.getRequestDispatcher("/buscarCliente.jsp").forward(request,response);
	}
	
	protected void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionCliente gsc = new GestionCliente();
		ClienteDTO objCliente = new ClienteDTO();
		objCliente.setId(Integer.parseInt(request.getParameter("id")));
		objCliente.setNombres(request.getParameter("nombres"));
		objCliente.setApePaterno(request.getParameter("apePaterno"));
		objCliente.setApeMaterno(request.getParameter("apeMaterno"));
		objCliente.setTipoDocumento(Integer.parseInt(request.getParameter("tipoDocumento")));
		objCliente.setNumero(request.getParameter("numeroDocumento"));
		objCliente.setIdDepartamento(Integer.parseInt(request.getParameter("departamento")));
		objCliente.setIdProvincia(Integer.parseInt(request.getParameter("provincia")));
		objCliente.setIdDistrito(Integer.parseInt(request.getParameter("distrito")));
		objCliente.setDireccion(request.getParameter("direccion"));
		objCliente.setEmail(request.getParameter("email"));
		objCliente.setCelular(request.getParameter("celular"));
		
		
		int cantidad = gsc.actualizarCliente(objCliente);
		if(cantidad > 0) {
			GestionDocumento gsd= new GestionDocumento();
			ArrayList<DocumentoDTO>listadoDocumento = gsd.listadoDocumento();
			request.setAttribute("listadoDocumento", listadoDocumento);
			request.getRequestDispatcher("buscarCliente.jsp").forward(request, response);
		}
		
	}
	
	protected void obtenerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionCliente gsc = new GestionCliente();
		ClienteDTO cliente = gsc.obtenerCliente(Integer.parseInt(request.getParameter("id")));
		GestionDocumento gsd = new GestionDocumento();
		GestionDepartamento gsde = new GestionDepartamento();
		GestionProvincia gsp = new GestionProvincia();
		GestionDistrito gsdis = new GestionDistrito();
		ArrayList<DocumentoDTO>listadoDocumento = gsd.listadoDocumento();
		ArrayList<DepartamentoDTO>listadoDepartamento = gsde.listadoDepartamento();
		ArrayList<ProvinciaDTO>listadoProvincia = gsp.listadoProvincia();
		ArrayList<DistritoDTO>listadoDistrito = gsdis.listadoDistrito();
		request.setAttribute("objCliente", cliente);
		request.setAttribute("listadoDocumento", listadoDocumento);
		request.setAttribute("listadoDepartamento", listadoDepartamento);
		request.setAttribute("listadoProvincia", listadoProvincia);
		request.setAttribute("listadoDistrito", listadoDistrito);
		request.getRequestDispatcher("modificarCliente.jsp").forward(request, response);
	}
	
	protected void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClienteDTO objCliente = new ClienteDTO();
		int cantidad = 0;
		GestionCliente gsc = new GestionCliente();
		
		objCliente.setId(Integer.parseInt(request.getParameter("id")));
		objCliente.setNombres(request.getParameter("nombres"));
		objCliente.setApePaterno(request.getParameter("apePaterno"));
		objCliente.setApeMaterno(request.getParameter("apeMaterno"));
		objCliente.setTipoDocumento(Integer.parseInt(request.getParameter("tipoDocumento")));
		objCliente.setNumero(request.getParameter("numeroDocumento"));
		objCliente.setIdDepartamento(Integer.parseInt(request.getParameter("departamento")));
		objCliente.setIdProvincia(Integer.parseInt(request.getParameter("provincia")));
		objCliente.setIdDistrito(Integer.parseInt(request.getParameter("distrito")));
		objCliente.setDireccion(request.getParameter("direccion"));
		objCliente.setEmail(request.getParameter("email"));
		objCliente.setCelular(request.getParameter("celular"));
		
		cantidad = gsc.agregarCliente(objCliente);
		if(cantidad>0) {
			request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{
			request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/registrarCliente.jsp").forward(request,response);	
		
	}

}
