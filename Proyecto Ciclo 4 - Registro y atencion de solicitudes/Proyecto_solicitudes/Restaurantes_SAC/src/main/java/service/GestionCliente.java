package service;

import java.util.ArrayList;

import beans.ClienteDTO;
import dao.DAOFactory;
import interfaces.ClienteDAO;
;

public class GestionCliente {
	
	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	ClienteDAO objClienteDAO = fabrica.getClienteDAO();
	
	public ArrayList<ClienteDTO>listarClienteFiltro(int tipo , String numero){
		return objClienteDAO.listadoClienteFiltro(tipo, numero);
	}
	
	public int actualizarCliente(ClienteDTO cliente) {
		return objClienteDAO.actualizarCliente(cliente);
	}
	
	public ClienteDTO obtenerCliente(int idCliente) {
		return objClienteDAO.obtenerCliente(idCliente);
	}
	
	public int agregarCliente(ClienteDTO cliente) {
		return objClienteDAO.agregarCliente(cliente);
	}

}
