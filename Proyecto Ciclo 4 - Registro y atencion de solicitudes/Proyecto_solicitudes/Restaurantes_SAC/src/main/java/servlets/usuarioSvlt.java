package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DocumentoDTO;
import beans.UsuarioDTO;
import service.GestionDocumento;
import service.GestionUsuario;

/**
 * Servlet implementation class usuarioSvlt
 */
@WebServlet("/usuarioSvlt")
public class usuarioSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private GestionUsuario gestionUsuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioSvlt() {
        super();
        // TODO Auto-generated constructor stub
        this.gestionUsuario = new GestionUsuario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		opcion = (opcion == null ? "error" : opcion);
		System.out.println("Opcion seleccionada es "+opcion);
		switch(opcion) {
			case "a": validar(request,response);break;
			case "listado": listadoDocumento(request, response);break;
			case "registrar" : registrarUsuario(request, response);break;
		default:
			response.sendRedirect("error.jsp");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		UsuarioDTO objUsuario = gestionUsuario.validarUsuario(usuario, clave);
		String tipo = objUsuario.getTipoUsuario();
		String mensaje="<script>alert('Bienvenido <strong>"+objUsuario.getNombre()+" "+objUsuario.getApePaterno()+"</strong>')</script>";

		if(tipo.equals("asesor")) {
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("menuAsesor.jsp").forward(request, response);
		}else if(tipo.equals("cliente")){
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("menuCliente.jsp").forward(request, response);
			}
		else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	protected void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsuarioDTO usuario = new UsuarioDTO();
		int cantidad = 0;
		GestionUsuario gsu = new GestionUsuario();
		usuario.setNombre(request.getParameter("txtNombre"));
		usuario.setApePaterno(request.getParameter("txtApePaterno"));
		usuario.setApeMaterno(request.getParameter("txtApeMaterno"));
		usuario.setTipoDocumento(Integer.parseInt(request.getParameter("tipoDocumento")));
		usuario.setNumeroDocumento(request.getParameter("txtNumeroDocumento"));
		usuario.setNombreUsuario(request.getParameter("txtUsuario"));
		usuario.setContrasenia(request.getParameter("txtContrasenia"));
		usuario.setTipoUsuario(request.getParameter("txtTipoUsuario"));
		
		cantidad = gsu.agregarUsuario(usuario);
		
		if(cantidad>0) {
			request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{
			request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/login.jsp").forward(request,response);	
		
	}
	
	protected void listadoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GestionDocumento gsd = new GestionDocumento();
		ArrayList<DocumentoDTO>listadoDocumento = gsd.listadoDocumento();
		request.setAttribute("listadoDocumento", listadoDocumento);
		request.getRequestDispatcher("/registrarUsuario.jsp").forward(request, response);
	}

}
