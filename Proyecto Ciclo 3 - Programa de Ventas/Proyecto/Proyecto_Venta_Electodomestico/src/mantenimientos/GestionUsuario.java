package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Producto;
import model.TipoComprobantePago;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	@Override
	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_vendedor, nombre_vendedor, apellido_vendedor, dni_vendedor from usuario ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_vendedor(rs.getString(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setDni(rs.getString(4));
				lista.add(usuario);
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
	public Usuario obtenerUsuario(String id_vendedor) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_vendedor, nombre_vendedor, apellido_vendedor, dni_vendedor from usuario where id_vendedor=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id_vendedor);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId_vendedor(rs.getString(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setDni(rs.getString(4));
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
		return usuario;
	}

	@Override
	public int registrarUsuario(Usuario usuario) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into usuario values ( ?,?,?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setString(1,usuario.getId_vendedor());
			pst.setString(2,usuario.getNombre());
			pst.setString(3,usuario.getApellido());
			pst.setString(4, usuario.getDni());
			
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
	public int actualizarUsuario(Usuario usuario) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update usuario set nombre_vendedor=? ,apellido_vendedor=? ,dni_vendedor=? where id_vendedor=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1,usuario.getNombre());
			pst.setString(2,usuario.getApellido());
			pst.setString(3,usuario.getDni());
			pst.setString(4,usuario.getId_vendedor());
			
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
	public ArrayList<Usuario> buscarUsuarioPorFiltro(Usuario usuario) {
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select id_vendedor, nombre_vendedor, apellido_vendedor, dni_vendedor from usuario  "+
				   		" where id_vendedor like CONCAT ( '%',?,'%') and nombre_vendedor like CONCAT ( '%',?,'%') and apellido_vendedor like CONCAT ( '%',?,'%') "; 
		 
		   pst = con.prepareStatement(sql);	 
		   //Paso 5: establecer los parametros ( si es que los hubiera depende de la sentencia sql ) 
		   pst.setString(1, usuario.getId_vendedor());
		   pst.setString(2, usuario.getNombre());
		   pst.setString(3, usuario.getApellido());
		   
		   //Paso 6: ejecutar sentencia sql
		   rs = pst.executeQuery(); 
		   //Paso 7: recorrer el bucle para obtener los registros que se obtuvieron en el paso 6
		   while (rs.next()){ //Extraer los datos 
			   Usuario objusuario = new Usuario(); 
			objusuario.setId_vendedor(rs.getString(1));
			objusuario.setNombre(rs.getString(2));
			objusuario.setApellido(rs.getString(3));
			objusuario.setDni(rs.getString(4));
			lista.add(objusuario);
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
