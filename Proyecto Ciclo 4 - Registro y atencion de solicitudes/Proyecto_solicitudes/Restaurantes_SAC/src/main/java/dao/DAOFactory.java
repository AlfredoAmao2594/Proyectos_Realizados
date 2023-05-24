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


public abstract class DAOFactory {
    //Constantes que representan las BD
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    //M�todo que implementar�n las clase hija
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract ClienteDAO getClienteDAO();
    public abstract ComprobantePagoDAO getComprobantePagoDAO();
    public abstract DepartamentoDAO getDepartamentoDAO();
    public abstract DistritoDAO getDistritoDAO();
    public abstract DocumentoDAO getDocumentoDAO();
    public abstract ProvinciaDAO getProvincia();
    public abstract SolicitudDAO getSolicitudDAO();
    
    
    //M�todo est�tico que obtiene la implementaci�n seg�n BD seleccionada 
    public static DAOFactory getDAOFactory(int whichFactory){
       switch(whichFactory){
       	/*case SQLSERVER:
       	    return new MySqlDAOFactory();*/
       	case MYSQL:
       		return new SqlDAOFactory();
       	/*case DB2:
       	    return new Db2DAOFactory();
       	case SQLSERVER:
       	    return new SqlServerDAOFactory();
       	case XML:
       	    return new XmlDAOFactory();*/
       	default:
       	    return null;
       }
    }
    
    
}
