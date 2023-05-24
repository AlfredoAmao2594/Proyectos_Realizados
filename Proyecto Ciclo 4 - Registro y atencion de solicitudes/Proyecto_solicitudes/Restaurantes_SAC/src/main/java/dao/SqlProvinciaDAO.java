package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DocumentoDTO;
import beans.ProvinciaDTO;
import interfaces.ProvinciaDAO;
import utils.MySQLConexion;

public class SqlProvinciaDAO implements ProvinciaDAO {

	@Override
	public ArrayList<ProvinciaDTO> listadoProvincia() {
		// TODO Auto-generated method stub
		ArrayList<ProvinciaDTO>listaProvincia = new ArrayList<ProvinciaDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql= "select * from provincia ";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			rs=pst.executeQuery();
			while(rs.next()) {
				ProvinciaDTO provincia=new ProvinciaDTO();
				provincia.setId(rs.getInt("idProvincia"));
				provincia.setDescripcion(rs.getString("desProvincia"));
				listaProvincia.add(provincia);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return listaProvincia;
	}

}
