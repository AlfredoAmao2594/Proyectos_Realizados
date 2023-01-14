package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import interfaces.TicketInterface;
import model.Cliente;
import model.Ticket;
import utils.MySQLConexion;

public class GestionTicket implements TicketInterface {

	@Override
	public ArrayList<Ticket> listarTicket() {
		
		ArrayList<Ticket> lista = new ArrayList<Ticket>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select numero_ticket, fecha, id_producto, deta_producto, precio, id_vendedor,cantidad, codEstado from ticket ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setNumero_Ticket(rs.getString(1));
				ticket.setFechaTick(rs.getString(2));
				ticket.setId_producto(rs.getInt(3));
				ticket.setDetalle_producto(rs.getString(4));
				ticket.setPrecio(rs.getDouble(5));
				ticket.setId_vendedor(rs.getString(6));
				ticket.setCantidad(rs.getInt(7));
				ticket.setEstado(rs.getInt(8));
				lista.add(ticket);
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
	public Ticket obtenerTicket(String numero) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Ticket ticket = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select numero_ticket, fecha, id_producto, deta_producto, precio, id_vendedor,cantidad, codEstado from ticket where numero_ticket=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,numero);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				ticket = new Ticket();
				ticket.setNumero_Ticket(rs.getString(1));
				ticket.setFechaTick(rs.getString(2));
				ticket.setId_producto(rs.getInt(3));
				ticket.setDetalle_producto(rs.getString(4));
				ticket.setPrecio(rs.getDouble(5));
				ticket.setId_vendedor(rs.getString(6));
				ticket.setCantidad(rs.getInt(7));
				ticket.setEstado(rs.getInt(8));
			}
		}catch (Exception ex) { 
			System.out.println("Ocurrio un evento inesperado método obtenerTicket: "+ex.getMessage());
		}finally {
		           try {//Paso 8 : cerrar los objetos 
		           		if (rs!= null)    rs.close();
						if (pstmt!= null) pstmt.close(); 
						if (con!= null)  con.close();
		           }catch (Exception ex2) { 
		           	    System.out.println("Error al cerrar conexión: "+ex2.getMessage());
		           }
		}
		return ticket;
	}

	@Override
	public int registrarTicket(Ticket ticket) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert ticket values ( ?,?,?,?,?,?,?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setString(1,ticket.getNumero_Ticket());
			pst.setString(2,ticket.getFechaTick());
			pst.setInt(3,ticket.getId_producto());
			pst.setString(4,ticket.getDetalle_producto());
			pst.setDouble(5,ticket.getPrecio());
			pst.setString(6,ticket.getId_vendedor());
			pst.setInt(7, ticket.getCantidad());
			pst.setInt(8, ticket.getcodEstado());
			
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
	public int actualizarTicket(Ticket ticket) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update ticket set id_producto=?, deta_producto=?, precio=?, id_vendedor=?, cantidad=?, codEstado=? where numero_ticket=? ";
			
			pst= con.prepareStatement(sql);
			
			pst.setString(1,ticket.getNumero_Ticket());
			pst.setString(2,ticket.getFechaTick());
			pst.setInt(3,ticket.getId_producto());
			pst.setString(4,ticket.getDetalle_producto());
			pst.setDouble(5,ticket.getPrecio());
			pst.setString(6,ticket.getId_vendedor());
			pst.setInt(7, ticket.getCantidad());
			pst.setInt(8, ticket.getcodEstado());
			
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
	public int eliminarTicket(String ticket) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from ticket where numero_ticket=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1,ticket);
			
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
	public String generarNumeroTicket() {
		ArrayList<Ticket> listaTicket = listarTicket();
		DecimalFormat df = new DecimalFormat("0000");
		int codigo=1;
		 if (listaTicket!=null && listaTicket.size()!=0){
			Ticket ticket= listaTicket.get(listaTicket.size()-1); 
			codigo=Integer.parseInt(ticket.getNumero_Ticket().substring(1)) + 1;
		 } 
		return "T"+df.format(codigo);
	}

	@Override
	public ArrayList<Ticket> listarTicketPorEstado(int estado) {
		ArrayList<Ticket> lista = new ArrayList<Ticket>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		
		   con = MySQLConexion.getConexion();
		
		   String sql = " SELECT numero_ticket , fecha, id_producto,deta_producto, precio,id_vendedor,cantidad from ticket where codEstado =? "; 
		   
		   pst = con.prepareStatement(sql);	 
		   
		   pst.setInt(1, estado);
		  
		   rs = pst.executeQuery(); 
		  
		   while (rs.next()){ 
			   Ticket ticket = new Ticket(); 
			   ticket.setNumero_Ticket(rs.getString(1));
			   ticket.setFechaTick(rs.getString(2));
			   ticket.setId_producto(rs.getInt(3));
			   ticket.setDetalle_producto(rs.getString(4));
			   ticket.setPrecio(rs.getDouble(5));
			   ticket.setId_vendedor(rs.getString(6));
			   ticket.setCantidad(rs.getInt(7));
			 
			   lista.add(ticket);
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

	@Override
	public ArrayList<Ticket> buscarTicketPorFiltro(Ticket ticket) {
		
		ArrayList<Ticket> lista = new ArrayList<Ticket>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select numero_ticket, fecha, id_producto,deta_producto,precio,cantidad from ticket "+
				   		" where numero_ticket like CONCAT ('%',?,'%' ) AND codEstado=1 "; 
		 
		   pst = con.prepareStatement(sql);	 
		   
		   pst.setString(1, ticket.getNumero_Ticket());
		   
		   rs = pst.executeQuery(); 
		   
		   while (rs.next()){ 
			Ticket objticket = new Ticket(); 
			objticket.setNumero_Ticket(rs.getString(1));
			objticket.setFechaTick(rs.getString(2));
			objticket.setId_producto(rs.getInt(3));
			objticket.setDetalle_producto(rs.getString(4));
			objticket.setPrecio(rs.getDouble(5));
			objticket.setCantidad(rs.getInt(6));
			lista.add(objticket);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try {
				  if (rs!= null)    rs.close();
			      if (pst != null) 	pst.close();
			      if (con != null) 	con.close();
			   } catch (SQLException e) {
			      System.out.println("Error al cerrar conexión");
			   }
		}
		return lista;
	}

	@Override
	public int actualizarEstadoTicket(ArrayList<Ticket> ticket) {
		
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			
			con.setAutoCommit(false);
			
			String sql = "update ticket set codEstado=? where numero_ticket=? ";
			
			
			for( Ticket tic : ticket) {
				pst= con.prepareStatement(sql);
				
		
				pst.setInt(1, tic.getcodEstado());
				pst.setString(2,tic.getNumero_Ticket());
				
				resultado = pst.executeUpdate();
			}
			
			con.commit();
			
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

}
