package service;

import java.util.ArrayList;

import beans.ComprobantePagoDTO;
import dao.DAOFactory;
import interfaces.ComprobantePagoDAO;


public class GestionComprobantePago {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	ComprobantePagoDAO objComporbantePagoDAO = fabrica.getComprobantePagoDAO();
	
	public ComprobantePagoDTO obtenerComprobante (String tipo , int numero){
		return objComporbantePagoDAO.obtenerComprobante(tipo, numero);
	}
}
