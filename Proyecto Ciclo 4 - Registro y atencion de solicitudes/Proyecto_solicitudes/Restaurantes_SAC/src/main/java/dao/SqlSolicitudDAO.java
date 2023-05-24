/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.SolicitudDTO;
import beans.UsuarioDTO;
import interfaces.SolicitudDAO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion;

/**
 * @author jalia_000
 *
 */

 public class SqlSolicitudDAO implements SolicitudDAO{

	@Override
	public ArrayList<SolicitudDTO> listadoSolicitudes() {
		// TODO Auto-generated method stub
		ArrayList<SolicitudDTO> listaSolicitud =new ArrayList<SolicitudDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql = "select idSolicitud, tipoDocumento,numeroDocumento,nombres,apellidoPaterno,apellidoMaterno,tipoSolicitud,"
				+ "fechaSolicitud,estado from tb_solicitud ";
		
		try {
			cnx= MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				SolicitudDTO solicitud= new SolicitudDTO();
				solicitud.setId(rs.getInt("idSolicitud"));
				solicitud.setTipoDocumento(rs.getInt("tipoDocumento"));
				solicitud.setNumeroDocumento(rs.getString("numeroDocumento"));
				solicitud.setNombres(rs.getString("nombres"));
				solicitud.setApePaterno(rs.getString("apellidoPaterno"));
				solicitud.setApeMaterno(rs.getString("apellidoMaterno"));
				solicitud.setTipoSolicitud(rs.getString("tipoSolicitud"));
				solicitud.setFechaSolicitud(rs.getString("fechaSolicitud"));
				solicitud.setEstado(rs.getString("estado"));
				listaSolicitud.add(solicitud);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return listaSolicitud ;
	}

	@Override
	public ArrayList<SolicitudDTO> listadoFiltroSolicitudes(int id) {
		// TODO Auto-generated method stub
		ArrayList<SolicitudDTO> listaSolicitud =new ArrayList<SolicitudDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql = "select idSolicitud, tipoDocumento,numeroDocumento,apellidoPaterno,apellidoMaterno,tipoSolicitud,"
				+ "fechaSolicitud,estado from tb_solicitud where ";
		try {
			cnx= MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				SolicitudDTO solicitud= new SolicitudDTO();
				solicitud.setId(rs.getInt("idSolicitud"));
				solicitud.setTipoDocumento(rs.getInt("tipoDocumento"));
				solicitud.setNumeroDocumento(rs.getString("numeroDocumento"));
				solicitud.setNombres(rs.getString("nombres"));
				solicitud.setApePaterno(rs.getString("apellidoPaterno"));
				solicitud.setApeMaterno(rs.getString("apellidoMaterno"));
				solicitud.setTipoSolicitud(rs.getString("tipoSolicitud"));
				solicitud.setFechaSolicitud(rs.getString("fechaSolicitud"));
				solicitud.setEstado(rs.getString(rs.getString("estado")));
				listaSolicitud.add(solicitud);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		MySQLConexion.closeConexion(cnx);
		MySQLConexion.closeStatement(pst);
		return listaSolicitud;
	}

	@Override
	public int agregarSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		PreparedStatement pst = null;
		Connection cnx = null;
		String strSql = "insert into tb_solicitud values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			cnx = MySQLConexion.getConexion();
			pst = cnx.prepareStatement(strSql);
			pst.setInt(1, solicitud.getId());
			pst.setInt(2, solicitud.getTipoDocumento());
			pst.setString(3, solicitud.getNumeroDocumento());
			pst.setString(4, solicitud.getNombres());
			pst.setString(5, solicitud.getApePaterno());
			pst.setString(6, solicitud.getApeMaterno());
			pst.setString(7, solicitud.getTelefono());
			pst.setString(8, solicitud.getCelular());
			pst.setString(9, solicitud.getCorreo());
			pst.setInt(10, solicitud.getDepartamento());
			pst.setInt(11, solicitud.getProvincia());
			pst.setInt(12, solicitud.getDistrito());
			pst.setString(13, solicitud.getDireccion());
			pst.setString(14, solicitud.getTipoSolicitud());
			pst.setString(15, solicitud.getTipoMotivo());
			pst.setString(16, solicitud.getFechaSolicitud());
			pst.setString(17, solicitud.getFechaComprobante());
			pst.setString(18, solicitud.getTipoComprobante());
			pst.setString(19, solicitud.getNumeroComprobante());
			pst.setString(20, solicitud.getTienda());
			pst.setString(21, solicitud.getServicio());
			pst.setString(22, solicitud.getDescripcionSolicitud());
			pst.setString(23, solicitud.getRespuestaSolicitud());
			pst.setString(24, solicitud.getEstado());
			cantidad=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion: "+e.getMessage());
		}
		
		return cantidad;
	}

	@Override
	public SolicitudDTO obtenerSolicitud(int id) {
		// TODO Auto-generated method stub
		SolicitudDTO solicitud = null;
		PreparedStatement pst = null;
		Connection cnx = null;
		ResultSet rs = null;
		String strSql = "select * from tb_solicitud where idSolicitud=?";
		
		try {
			cnx = MySQLConexion.getConexion();
			pst= cnx.prepareStatement(strSql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				solicitud = new SolicitudDTO();
				solicitud.setId(rs.getInt("idSolicitud"));
				solicitud.setTipoDocumento(rs.getInt("tipoDocumento"));
				solicitud.setNumeroDocumento(rs.getString("numeroDocumento"));
				solicitud.setNombres(rs.getString("nombres"));
				solicitud.setApePaterno(rs.getString("apellidoPaterno"));
				solicitud.setApeMaterno(rs.getString("apellidoMaterno"));
				solicitud.setTelefono(rs.getString("telefono"));
				solicitud.setCelular(rs.getString("celular"));
				solicitud.setCorreo(rs.getString("correo"));
				solicitud.setDepartamento(rs.getInt("departamento"));
				solicitud.setProvincia(rs.getInt("provincia"));
				solicitud.setDistrito(rs.getInt("distrito"));
				solicitud.setDireccion(rs.getString("direccion"));
				solicitud.setTipoSolicitud(rs.getString("tipoSolicitud"));
				solicitud.setTipoMotivo(rs.getString("tipoMotivo"));
				solicitud.setFechaSolicitud(rs.getString("fechaSolicitud"));
				solicitud.setFechaComprobante(rs.getString("fechaComprobante"));
				solicitud.setTipoComprobante(rs.getString("tipoComprobante"));
				solicitud.setNumeroComprobante(rs.getString("numeroComprobante"));
				solicitud.setTienda(rs.getString("tienda"));
				solicitud.setServicio(rs.getString("servicio"));
				solicitud.setDescripcionSolicitud(rs.getString("descripcionSolicitud"));
				solicitud.setRespuestaSolicitud(rs.getString("respuestaSolicitud"));
				solicitud.setEstado(rs.getString("estado"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("se suscito la siguiente excepcion:"+e.getMessage());
			e.printStackTrace();
		}
		return solicitud;
	}

	@Override
	public int modificarSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		Connection cnx = null;
		PreparedStatement pst = null;
		String strSql = "update tb_solicitud set respuestaSolicitud=? , estado=? where idSolicitud=? ";
		
		try {
			cnx= MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setString(1, solicitud.getRespuestaSolicitud());
			pst.setString(2, solicitud.getEstado());
			pst.setInt(3, solicitud.getId());
			
			cantidad = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return cantidad;
	}
}