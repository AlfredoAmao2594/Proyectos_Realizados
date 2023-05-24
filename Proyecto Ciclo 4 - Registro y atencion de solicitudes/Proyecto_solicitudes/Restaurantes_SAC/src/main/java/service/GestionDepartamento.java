package service;

import java.util.ArrayList;

import beans.DepartamentoDTO;
import dao.DAOFactory;
import interfaces.DepartamentoDAO;


public class GestionDepartamento {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	DepartamentoDAO objDepartamentoDAO = fabrica.getDepartamentoDAO();
	
	public ArrayList<DepartamentoDTO> listadoDepartamento(){
		return objDepartamentoDAO.listadoDepartamento();
	}
}
