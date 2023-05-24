/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion;

/**
 * @author jalia_000
 *
 */
public class SqlUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO validarLogueo(String idUsuario, String clave) {
		// TODO Auto-generated method stub
		UsuarioDTO usuario = null;
		PreparedStatement pst = null;
		Connection cnx = null;
		ResultSet rs = null;
		String strSql = "Select * from tb_usuario where nombreUsuario=? and contrasenia=?";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setString(1, idUsuario);
			pst.setString(2, clave);
			rs=pst.executeQuery();
			if(rs.next()) {
				usuario = new UsuarioDTO();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApePaterno(rs.getString("apellidoPaterno"));
				usuario.setApeMaterno(rs.getString("apellidoMaterno"));
				usuario.setTipoDocumento(rs.getInt("tipoDocumento"));
				usuario.setNumeroDocumento(rs.getString("numeroDocumento"));
				usuario.setNombreUsuario(rs.getString("nombreUsuario"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setTipoUsuario(rs.getString("tipoUsuario"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		}
		MySQLConexion.closeConexion(cnx);
		MySQLConexion.closeStatement(pst);
		System.out.println(usuario);
		return usuario;
	}

	@Override
	public int agregarUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		PreparedStatement pst = null;
		Connection cnx = null;
		String strSql="insert into tb_usuario values (?,?,?,?,?,?,?,?)";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApePaterno());
			pst.setString(3, usuario.getApeMaterno());
			pst.setInt(4, usuario.getTipoDocumento());
			pst.setString(5, usuario.getNumeroDocumento());
			pst.setString(6, usuario.getUsuario());
			pst.setString(7, usuario.getContrasenia());
			pst.setString(8, usuario.getTipoUsuario());
			cantidad = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion: "+e.getMessage());
		}
		MySQLConexion.closeConexion(cnx);
		MySQLConexion.closeStatement(pst);
		return cantidad;
	}


}
