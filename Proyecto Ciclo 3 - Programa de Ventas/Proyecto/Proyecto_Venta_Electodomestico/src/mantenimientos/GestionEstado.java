package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.EstadoInterface;
import model.Estado;
import utils.MySQLConexion;

public class GestionEstado implements EstadoInterface{

	@Override
	public ArrayList<Estado> listarEstado() {
		
		ArrayList<Estado> lista = new ArrayList<Estado>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		
		   con = MySQLConexion.getConexion();
		  
		   String sql = " select codEstado, desEstado from estado "; 
	
		   pst = con.prepareStatement(sql);	 
	
		   rs = pst.executeQuery(); 
	
		   while (rs.next()){  
			   Estado estado = new Estado(); 
			   estado.setCodEstado(rs.getInt(1));
			   estado.setDesEstado(rs.getString(2)); 
			   lista.add(estado);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try {//Paso 8 : cerrar los objetos 
				  if (rs!= null)    rs.close();
			      if (pst != null) 	pst.close();
			      if (con != null) 	con.close();
			   } catch (SQLException e) {
			      System.out.println("Error al cerrar conexión");
			   }
		}
		//Paso 9 : Se retorna la lista 
		return lista;
	}

}
