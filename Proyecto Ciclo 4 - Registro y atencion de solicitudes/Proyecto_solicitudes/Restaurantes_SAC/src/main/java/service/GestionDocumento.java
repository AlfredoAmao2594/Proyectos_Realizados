package service;

import java.util.ArrayList;

import beans.DocumentoDTO;
import dao.DAOFactory;
import interfaces.DocumentoDAO;


public class GestionDocumento {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	DocumentoDAO objDocumentoDAO = fabrica.getDocumentoDAO();
	
	public ArrayList<DocumentoDTO>listadoDocumento(){
		return objDocumentoDAO.listadoDocumento();
	}
}
