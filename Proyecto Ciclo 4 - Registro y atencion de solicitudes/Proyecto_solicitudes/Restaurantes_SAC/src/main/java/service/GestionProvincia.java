package service;

import java.util.ArrayList;

import beans.ProvinciaDTO;
import dao.DAOFactory;
import interfaces.ProvinciaDAO;

public class GestionProvincia {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	ProvinciaDAO objProvinciaDAO = fabrica.getProvincia();
	
	public ArrayList<ProvinciaDTO>listadoProvincia(){
		return objProvinciaDAO.listadoProvincia();
	}
}
