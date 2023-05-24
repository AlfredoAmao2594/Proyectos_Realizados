package service;

import java.util.ArrayList;

import beans.DistritoDTO;
import dao.DAOFactory;
import interfaces.DistritoDAO;

public class GestionDistrito {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	DistritoDAO objDistritoDAO = fabrica.getDistritoDAO();
	
	public ArrayList<DistritoDTO>listadoDistrito(){
		return objDistritoDAO.listadoDistrito();
	}
}
