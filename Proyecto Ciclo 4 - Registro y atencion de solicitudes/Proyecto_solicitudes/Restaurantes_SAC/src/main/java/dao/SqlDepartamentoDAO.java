package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DepartamentoDTO;
import interfaces.DepartamentoDAO;
import utils.MySQLConexion;

public class SqlDepartamentoDAO implements DepartamentoDAO {

	@Override
	public ArrayList<DepartamentoDTO> listadoDepartamento() {
		// TODO Auto-generated method stub
		ArrayList<DepartamentoDTO>listaDepartamento = null;
		DepartamentoDTO objDepartamento = null;
		PreparedStatement pst = null;
		Connection cnx = null;
		ResultSet rs = null;
		
		try {
			cnx= MySQLConexion.getConexion();
			String sql = "select * from departamento ";
			pst = cnx.prepareStatement(sql);
			rs = pst.executeQuery();
			listaDepartamento = new ArrayList<DepartamentoDTO>();
			while(rs.next()) {
				objDepartamento= new DepartamentoDTO();
				objDepartamento.setId(rs.getInt("idDepartamento"));
				objDepartamento.setDescripcion(rs.getString("desDepartamento"));
				listaDepartamento.add(objDepartamento);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		}
		MySQLConexion.closeConexion(cnx);
		MySQLConexion.closeStatement(pst);
		
		return listaDepartamento;
	}

}
