package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import model.Proveedor;
import utils.MySQLConexion;

public class GestionProducto implements ProductoInterface{

	@Override
	public ArrayList<Producto> listarProducto() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_producto, deta_producto, marca, precio, id_proveedor from producto ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId_producto(rs.getInt(1));
				producto.setDetalle(rs.getString(2));
				producto.setMarca(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setId_proveedor(rs.getLong(5));
				lista.add(producto);
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
	public Producto obtenerProducto(int id_producto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Producto producto = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_producto, deta_producto, marca, precio, id_proveedor from producto where id_producto=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,id_producto);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt(1));
				producto.setDetalle(rs.getString(2));
				producto.setMarca(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setId_proveedor(rs.getLong(5));
			}
		}catch (Exception ex) { 
			System.out.println("Ocurrio un evento inesperado método obtener Producto: "+ex.getMessage());
		}finally {
		           try {
		           		if (rs!= null)    rs.close();
						if (pstmt!= null) pstmt.close(); 
						if (con!= null)  con.close();
		           }catch (Exception ex2) { 
		           	    System.out.println("Error al cerrar conexión: "+ex2.getMessage());
		           }
		}
		return producto;
	}

	@Override
	public int registrarProducto(Producto producto) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into producto values ( ?,?,?,?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setInt(1,producto.getId_producto());
			pst.setString(2, producto.getDetalle());
			pst.setString(3,producto.getMarca());
			pst.setDouble(4, producto.getPrecio());
			pst.setLong(5,producto.getId_proveedor());
					
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
	public int actualizarProducto(Producto producto) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update producto set deta_producto=? , marca=? , precio=? , id_proveedor=? where id_producto=?";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, producto.getDetalle());
			pst.setString(2,producto.getMarca());
			pst.setDouble(3, producto.getPrecio());
			pst.setLong(4,producto.getId_proveedor());
			pst.setInt(5,producto.getId_producto());
			
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
	public int eliminarProducto(int id_producto) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from producto where id_producto=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,id_producto);
			
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
	public ArrayList<Producto> buscarProductoPorFiltro(Producto producto) {
		
		ArrayList<Producto> lista = new ArrayList<Producto>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select id_producto, deta_producto, marca, precio, id_proveedor from producto  "+
				   		" where deta_producto like CONCAT ( '%',?,'%') and marca like CONCAT ( '%',?,'%') "; 
		 
		   pst = con.prepareStatement(sql);	 
		   //Paso 5: establecer los parametros ( si es que los hubiera depende de la sentencia sql ) 
		   pst.setString(1, producto.getDetalle());
		   pst.setString(2, producto.getMarca());
		   
		   //Paso 6: ejecutar sentencia sql
		   rs = pst.executeQuery(); 
		   //Paso 7: recorrer el bucle para obtener los registros que se obtuvieron en el paso 6
		   while (rs.next()){ //Extraer los datos 
			   Producto objproducto = new Producto(); 
			objproducto.setId_producto(rs.getInt(1));
			objproducto.setDetalle(rs.getString(2));
			objproducto.setMarca(rs.getString(3));
			objproducto.setPrecio(rs.getDouble(4));
			objproducto.setId_proveedor(rs.getLong(5));
			lista.add(objproducto);
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
