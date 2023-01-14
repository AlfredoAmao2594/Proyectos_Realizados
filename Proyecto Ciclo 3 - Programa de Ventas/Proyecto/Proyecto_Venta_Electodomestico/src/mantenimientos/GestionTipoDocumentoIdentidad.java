package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TipoDocumentoIdentidadInterface;
import model.TipoComprobantePago;
import model.TipoDocumentoIdentidad;
import utils.MySQLConexion;

public class GestionTipoDocumentoIdentidad implements TipoDocumentoIdentidadInterface {

	@Override
	public ArrayList<TipoDocumentoIdentidad> listarTipoDocumentoIdentidad() {
		ArrayList<TipoDocumentoIdentidad> lista = new ArrayList<TipoDocumentoIdentidad>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select codigo_doc, detalle from tipo_documento_identidad ";
			
			pst = con.prepareStatement(sql);
			
			rs= pst.executeQuery();
			
			while(rs.next()) {
				TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
				tipoDocumentoIdentidad.setCodigo(rs.getInt(1));
				tipoDocumentoIdentidad.setDetalle(rs.getString(2));
				lista.add(tipoDocumentoIdentidad);
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
	public TipoDocumentoIdentidad obtenerDocumentoIdentidad(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TipoDocumentoIdentidad tipoDocumentoIdentidad = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " select codigo_doc, detalle from tipo_documento_identidad where codigo_doc=? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,codigo);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
				tipoDocumentoIdentidad.setCodigo(rs.getInt(1));
				tipoDocumentoIdentidad.setDetalle(rs.getString(2));
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
		return tipoDocumentoIdentidad;
	}

	@Override
	public int registrarDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into tipo_documento_identidad values ( ?,? )";
			
			pst= con.prepareStatement(sql);
			
			pst.setInt(1,tipoDocumentoIdentidad.getCodigo());
			pst.setString(2,tipoDocumentoIdentidad.getDetalle());
			
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
	public int actualizarDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
		int resultado = -1;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " update tipo_documento_identidad set detalle=? where codigo_doc=?";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1,tipoDocumentoIdentidad.getDetalle());
			pst.setInt(2,tipoDocumentoIdentidad.getCodigo());
			
			
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
	public int eliminarDocumentoIdentidad(int codigo) {
		int resultado = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			
			String sql = " delete from tipo_documento_identidad where codigo_doc=? ";
			
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
