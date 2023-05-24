package interfaces;

import java.util.ArrayList;

import beans.SolicitudDTO;

public interface SolicitudDAO {

	public ArrayList<SolicitudDTO>listadoSolicitudes();
	public ArrayList<SolicitudDTO>listadoFiltroSolicitudes(int id);
	public int agregarSolicitud(SolicitudDTO solicitud);
	public SolicitudDTO obtenerSolicitud(int id);
	public int modificarSolicitud(SolicitudDTO solicitud);
	
}
