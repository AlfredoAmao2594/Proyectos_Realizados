/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package dao;

import interfaces.ClienteDAO;
import interfaces.ComprobantePagoDAO;
import interfaces.DepartamentoDAO;
import interfaces.DistritoDAO;
import interfaces.DocumentoDAO;
import interfaces.ProvinciaDAO;
import interfaces.SolicitudDAO;
import interfaces.UsuarioDAO;


public class SqlDAOFactory extends DAOFactory{

	
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new SqlUsuarioDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new SqlClienteDAO();
	}

	@Override
	public ComprobantePagoDAO getComprobantePagoDAO() {
		// TODO Auto-generated method stub
		return new SqlComprobantePagoDAO();
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		// TODO Auto-generated method stub
		return new SqlDepartamentoDAO();
	}

	@Override
	public DistritoDAO getDistritoDAO() {
		// TODO Auto-generated method stub
		return new SqlDistritoDAO();
	}

	@Override
	public DocumentoDAO getDocumentoDAO() {
		// TODO Auto-generated method stub
		return new SqlDocumentoDAO();
	}

	@Override
	public ProvinciaDAO getProvincia() {
		// TODO Auto-generated method stub
		return new SqlProvinciaDAO();
	}

	@Override
	public SolicitudDAO getSolicitudDAO() {
		// TODO Auto-generated method stub
		return new SqlSolicitudDAO();
	}
    
}
