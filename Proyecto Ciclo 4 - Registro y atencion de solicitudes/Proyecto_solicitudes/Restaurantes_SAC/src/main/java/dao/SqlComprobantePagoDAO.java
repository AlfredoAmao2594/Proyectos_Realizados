package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ComprobantePagoDTO;
import interfaces.ComprobantePagoDAO;
import utils.MySQLConexion;

public class SqlComprobantePagoDAO implements ComprobantePagoDAO {

	@Override
	public ComprobantePagoDTO obtenerComprobante(String tipo, int numero) {
		// TODO Auto-generated method stub
		ComprobantePagoDTO objComprobante = null;
		PreparedStatement pst = null;
		Connection cnx = null;
		ResultSet rs = null;
		
		try {
			cnx = MySQLConexion.getConexion();
			String sql = "select * from tb_comprobante_pago where tipoComprobante=? and numeroComprobante=? ";
			pst = cnx.prepareStatement(sql);
			pst.setString(1, tipo);
			pst.setInt(2, numero);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				objComprobante = new ComprobantePagoDTO();
				objComprobante.setTipo(rs.getString("tipoComprobante"));
				objComprobante.setNumero(rs.getInt("numeroComprobante"));
				objComprobante.setFecha(rs.getString("fechaComprobante"));
				objComprobante.setNombres(rs.getString("nombresCliente"));
				objComprobante.setApellidos(rs.getString("apellidosClientes"));
				objComprobante.setTipoDocumento(rs.getInt("tipDocumento"));
				objComprobante.setNumeroDocumento(rs.getString("numeroDocumento"));
				objComprobante.setImporte(rs.getDouble("importe"));
				objComprobante.setEstado(rs.getString("estado"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		}
	
		
		return objComprobante;
	}

}
