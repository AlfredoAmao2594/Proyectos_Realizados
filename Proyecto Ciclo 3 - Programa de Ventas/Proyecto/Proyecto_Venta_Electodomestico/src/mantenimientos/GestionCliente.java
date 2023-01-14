package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ClienteInterface;
import model.Cliente;
import model.Proveedor;
import utils.MySQLConexion;

public class GestionCliente implements ClienteInterface{

	@Override
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_cliente, codigo_doc, nombre_cliente, direccion_cñliente, telefono, correo from cliente ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getLong(1));
				cliente.setCodigo_doc(rs.getInt(2));
				cliente.setNombre_cliente(rs.getString(3));
				cliente.setDireccion_cliente(rs.getString(4));
				cliente.setTelefono(rs.getString(5));
				cliente.setCorreo(rs.getString(6));
				lista.add(cliente);
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
	public Cliente obtenerCliente(long id_cliente) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select id_cliente, codigo_doc, nombre_cliente, direccion_cñliente, telefono, correo from cliente where id_cliente=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1,id_cliente);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setId_cliente(rs.getLong(1));
				cliente.setCodigo_doc(rs.getInt(2));
				cliente.setNombre_cliente(rs.getString(3));
				cliente.setDireccion_cliente(rs.getString(4));
				cliente.setTelefono(rs.getString(5));
				cliente.setCorreo(rs.getString(6));
			}
		}catch (Exception ex) { 
			System.out.println("Ocurrio un evento inesperado método obtenerUsuario: "+ex.getMessage());
		}finally {
		           try {//Paso 8 : cerrar los objetos 
		           		if (rs!= null)    rs.close();
						if (pstmt!= null) pstmt.close(); 
						if (con!= null)  con.close();
		           }catch (Exception ex2) { 
		           	    System.out.println("Error al cerrar conexión: "+ex2.getMessage());
		           }
		}
		return cliente;
	}

	@Override
	public int registrarCliente(Cliente cliente) {
		
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into cliente values ( ?,?,?,?,?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setLong(1,cliente.getId_cliente());
			pst.setInt(2,cliente.getCodigo_doc());
			pst.setString(3,cliente.getNombre_cliente());
			pst.setString(4,cliente.getDireccion_cliente());
			pst.setString(5,cliente.getTelefono());
			pst.setString(6,cliente.getCorreo());
			
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
	public int actualizarCliente(Cliente cliente) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update cliente set codigo_doc=? , nombre_cliente=? , direccion_cñliente=?, telefono=?, correo=? where id_cliente=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,cliente.getCodigo_doc());
			pst.setString(2,cliente.getNombre_cliente());
			pst.setString(3,cliente.getDireccion_cliente());
			pst.setString(4,cliente.getTelefono());
			pst.setString(5,cliente.getCorreo());
			pst.setLong(6,cliente.getId_cliente());
			
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
	public int eliminarCliente(long id_cliente) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from cliente where id_cliente=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setLong(1,id_cliente);
			
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
	public ArrayList<Cliente> buscarClientePorFiltro(Cliente cliente) {
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select id_cliente, nombre_cliente, direccion_cñliente, telefono from cliente "+
				   		" where nombre_cliente like CONCAT ('%',?,'%' ) "; 
		 
		   pst = con.prepareStatement(sql);	 
		   
		   pst.setString(1, cliente.getNombre_cliente());
		   
		   rs = pst.executeQuery(); 
		   
		   while (rs.next()){ 
			Cliente objcliente = new Cliente(); 
			objcliente.setId_cliente(rs.getLong(1));
			objcliente.setNombre_cliente(rs.getString(2));
			objcliente.setDireccion_cliente(rs.getString(3));
			objcliente.setTelefono(rs.getString(4));
			lista.add(objcliente);
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
