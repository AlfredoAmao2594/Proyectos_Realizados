package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DistritoDTO;
import beans.DocumentoDTO;
import interfaces.DocumentoDAO;
import utils.MySQLConexion;

public class SqlDocumentoDAO implements DocumentoDAO{

	@Override
	public ArrayList<DocumentoDTO> listadoDocumento() {
		// TODO Auto-generated method stub
		ArrayList<DocumentoDTO>listaDocumento = new ArrayList<DocumentoDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql= "select * from tb_Documento ";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			rs=pst.executeQuery();
			while(rs.next()) {
				DocumentoDTO documento=new DocumentoDTO();
				documento.setTipoDocumento(rs.getInt("tipoDocumento"));
				documento.setDesDocumento(rs.getString("descripcionDocumento"));
				listaDocumento.add(documento);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return listaDocumento;
	}

}
