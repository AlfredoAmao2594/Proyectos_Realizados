package service;

import java.util.ArrayList;

import beans.SolicitudDTO;
import dao.DAOFactory;
import interfaces.SolicitudDAO;

public class GestionSolicitud {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	SolicitudDAO objSolicitudDAO = fabrica.getSolicitudDAO();
	
	public int agregarSolicitud(SolicitudDTO solicitud) {
		return objSolicitudDAO.agregarSolicitud(solicitud);
	}
	
	public ArrayList<SolicitudDTO>listadoSolicitud(){
		return objSolicitudDAO.listadoSolicitudes();
	}
	
	public SolicitudDTO obtenerSolicitud(int id) {
		return objSolicitudDAO.obtenerSolicitud(id);
	}
	
	public int modificarSolicitud(SolicitudDTO solicitud) {
		return  objSolicitudDAO.modificarSolicitud(solicitud);
	}
}
