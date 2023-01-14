package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TipoComprobantePagoInterface;
import model.Cliente;
import model.TipoComprobantePago;
import utils.MySQLConexion;

public class GestionTipoComprobantePago implements TipoComprobantePagoInterface {

	@Override
	public ArrayList<TipoComprobantePago> listarComprobantePago() {
		ArrayList<TipoComprobantePago> lista = new ArrayList<TipoComprobantePago>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select codigo_comp, detalle_comp from tipo_comprobante_pago ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				TipoComprobantePago tipoComprobantePago = new TipoComprobantePago();
				tipoComprobantePago.setCodigo(rs.getInt(1));
				tipoComprobantePago.setDetalle(rs.getString(2));
				lista.add(tipoComprobantePago);
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
	public TipoComprobantePago obtenerComprobantePago(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TipoComprobantePago tipoComprobantePago = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select codigo_comp, detalle_comp from tipo_comprobante_pago where codigo_comp=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,codigo);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				tipoComprobantePago = new TipoComprobantePago();
				tipoComprobantePago.setCodigo(rs.getInt(1));
				tipoComprobantePago.setDetalle(rs.getString(2));
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
		return tipoComprobantePago;
	}

	@Override
	public int registrarComprobantePago(TipoComprobantePago tipoComprobantePago) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into tipo_comprobante_pago values ( ?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setInt(1,tipoComprobantePago.getCodigo());
			pst.setString(2,tipoComprobantePago.getDetalle());
			
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
	public int actualizarComprobantePago(TipoComprobantePago tipoComprobantePago) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update tipo_comprobante_pago set detalle_comp=? where codigo_comp=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1,tipoComprobantePago.getDetalle());
			pst.setInt(2,tipoComprobantePago.getCodigo());
			
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
	public int eliminarComprobantePago(int codigo) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from tipo_comprobante_pago where codigo_comp=? ";
			
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,codigo);
			
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


}
