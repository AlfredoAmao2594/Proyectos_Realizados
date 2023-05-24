package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class GestionUsuario {

	int baseDatos=1;
	DAOFactory fabrica = DAOFactory.getDAOFactory(baseDatos);
	UsuarioDAO objUsuarioDAO = fabrica.getUsuarioDAO();
	
	public UsuarioDTO validarUsuario(String idUsuario, String clave) {
		return objUsuarioDAO.validarLogueo(idUsuario, clave);
	}
	
	public int agregarUsuario(UsuarioDTO usuario) {
		return objUsuarioDAO.agregarUsuario(usuario);
	}
}
