package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProveedorInterface;
import model.Cliente;
import model.Proveedor;
import utils.MySQLConexion;

public class GestionProveedor implements ProveedorInterface{

	@Override
	public ArrayList<Proveedor> listarProveedor() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_proveedor, razon_social, direccion, telefono, correo from proveedor ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Proveedor proveedor = new Proveedor();
				proveedor.setId_provedor(rs.getLong(1));
				proveedor.setRazon_social(rs.getString(2));
				proveedor.setDireccion(rs.getString(3));
				proveedor.setTelefono(rs.getString(4));
				proveedor.setCorreo(rs.getString(5));
				lista.add(proveedor);
			}
			
		}catch (Exception e) {
			System.out.println("Error en la sentencia " + e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pst!= null) pst.close();
				if(con!=null) con.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar conexión");
			}
		}
		
		return lista;
	}

	@Override
	public Proveedor obtenerProveedor(long id_proveedor) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Proveedor proveedor = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_proveedor, razon_social, direccion, telefono, correo from proveedor where id_proveedor=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1,id_proveedor);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				proveedor = new Proveedor();
				proveedor.setId_provedor(rs.getLong(1));
				proveedor.setRazon_social(rs.getString(2));
				proveedor.setDireccion(rs.getString(3));
				proveedor.setTelefono(rs.getString(4));
				proveedor.setCorreo(rs.getString(5));
			}
		}catch (Exception ex) { 
			System.out.println("Ocurrio un evento inesperado método obtenerUsuario: "+ex.getMessage());
		}finally {
		           try {
		           		if (rs!= null)    rs.close();
						if (pstmt!= null) pstmt.close(); 
						if (con!= null)  con.close();
		           }catch (Exception ex2) { 
		           	    System.out.println("Error al cerrar conexión: "+ex2.getMessage());
		           }
		}
		return proveedor;
	}

	@Override
	public int registrarProveedor(Proveedor proveedor) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into proveedor values ( ?,?,?,?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setLong(1,proveedor.getId_provedor());
			pst.setString(2, proveedor.getRazon_social());
			pst.setString(3,proveedor.getDireccion());
			pst.setString(4, proveedor.getTelefono());
			pst.setString(5,proveedor.getCorreo());
			
			resultado = pst.executeUpdate();
		}catch (Exception e) {
			   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try { 
				      if (pst != null) pst.close();
				      if (con != null) con.close();
				   } catch (SQLException e) {
					   System.out.println("Error al cerrar conexión: "+e.getMessage());
				   }
				}
		return resultado;
	}

	@Override
	public int actualizarProveedor(Proveedor proveedor) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update proveedor set razon_social=? , direccion=?, telefono=? , correo=? where id_proveedor=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, proveedor.getRazon_social());
			pst.setString(2,proveedor.getDireccion());
			pst.setString(3, proveedor.getTelefono());
			pst.setString(4, proveedor.getCorreo());
			pst.setLong(5,proveedor.getId_provedor());
			
			resultado = pst.executeUpdate();
			
		}catch (Exception e) {
			   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try { 
				      if (pst != null) pst.close();
				      if (con != null) con.close();
				   } catch (SQLException e) {
					   System.out.println("Error al cerrar conexión: "+e.getMessage());
				   }
				}
		return resultado;
	}

	@Override
	public int eliminarProveedor(long id_proveedor) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from proveedor where id_proveedor=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setLong(1,id_proveedor);
			
			resultado= pst.executeUpdate();
		} catch (Exception e) {
			   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try { 
				      if (pst != null) pst.close();
				      if (con != null) con.close();
				   } catch (SQLException e) {
					   System.out.println("Error al cerrar conexión: "+e.getMessage());
				   }
				}
		return resultado;   
	}

	@Override
	public ArrayList<Proveedor> buscarProveedorPorFiltro(Proveedor proveedor) {
		
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select id_proveedor, razon_social, direccion, telefono, correo from proveedor  "+
				   		" where razon_social like  CONCAT ( '%',?,'%') "; 
		 
		   pst = con.prepareStatement(sql);	 
		   //Paso 5: establecer los parametros ( si es que los hubiera depende de la sentencia sql ) 
		   pst.setString(1, proveedor.getRazon_social());
		   
		   //Paso 6: ejecutar sentencia sql
		   rs = pst.executeQuery(); 
		   //Paso 7: recorrer el bucle para obtener los registros que se obtuvieron en el paso 6
		   while (rs.next()){ //Extraer los datos 
			   Proveedor objproveedor = new Proveedor(); 
			objproveedor.setId_provedor(rs.getLong(1));
			objproveedor.setRazon_social(rs.getString(2));
			objproveedor.setDireccion(rs.getString(3));
			objproveedor.setTelefono(rs.getString(4));
			objproveedor.setCorreo(rs.getString(5));
			lista.add(objproveedor);
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
		//Paso 9 : Se retorna el  objeto libro 
		return lista;
	}

}
