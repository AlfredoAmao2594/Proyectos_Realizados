package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DistritoDTO;
import interfaces.DistritoDAO;
import utils.MySQLConexion;

public class SqlDistritoDAO implements DistritoDAO {

	@Override
	public ArrayList<DistritoDTO> listadoDistrito() {
		// TODO Auto-generated method stub
		ArrayList<DistritoDTO>listaDistrito = new ArrayList<DistritoDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql= "select * from distrito ";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			rs=pst.executeQuery();
			while(rs.next()) {
				DistritoDTO distrito=new DistritoDTO();
				distrito.setId(rs.getInt("idDistrito"));
				distrito.setDescripcion(rs.getString("desDistrito"));
				listaDistrito.add(distrito);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return listaDistrito;
	}

}
