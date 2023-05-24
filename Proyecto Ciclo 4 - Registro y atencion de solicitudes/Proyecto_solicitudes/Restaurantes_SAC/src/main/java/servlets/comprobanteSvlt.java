package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ComprobantePagoDTO;
import service.GestionComprobantePago;
import service.GestionDocumento;

/**
 * Servlet implementation class comprobanteSvlt
 */
@WebServlet("/comprobanteSvlt")
public class comprobanteSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comprobanteSvlt() {
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
			buscarComprobante(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void buscarComprobante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo = request.getParameter("idComprobante");
		int numero = Integer.parseInt(request.getParameter("txtNumeroCom"));
		GestionComprobantePago gscp = new GestionComprobantePago();
		ComprobantePagoDTO oComprobante = gscp.obtenerComprobante(tipo, numero);
		request.setAttribute("listadoComprobante", oComprobante);
		request.getRequestDispatcher("/buscarComprobante.jsp").forward(request, response);
	}

}
