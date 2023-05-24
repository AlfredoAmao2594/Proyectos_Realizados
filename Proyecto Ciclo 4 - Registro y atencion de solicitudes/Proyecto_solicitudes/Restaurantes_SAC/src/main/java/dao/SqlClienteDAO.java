package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import beans.ClienteDTO;
import interfaces.ClienteDAO;
import utils.MySQLConexion;

public class SqlClienteDAO implements ClienteDAO {

	@Override
	public int agregarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		Connection cnx = null;
		PreparedStatement pst = null;
		String strSql = " insert into tb_clientes values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst = cnx.prepareStatement(strSql);
			pst.setInt(1, cliente.getId());
			pst.setString(2,cliente.getNombres());
			pst.setString(3, cliente.getApePaterno());
			pst.setString(4, cliente.getApeMaterno());
			pst.setInt(5, cliente.getTipoDocumento());
			pst.setString(6, cliente.getNumero());
			pst.setInt(7, cliente.getIdDepartamento());
			pst.setInt(8, cliente.getIdProvincia());
			pst.setInt(9, cliente.getIdDistrito());
			pst.setString(10, cliente.getDireccion());
			pst.setString(11, cliente.getEmail());
			pst.setString(12, cliente.getCelular());
			cantidad = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion: "+e.getMessage());
		}
		
		return cantidad;
	}

	@Override
	public int actualizarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		Connection cnx= null;
		PreparedStatement pst = null;
		String strSql = "Update tb_clientes set nombres=?,apellidoPaterno=?,apellidoMaterno=?,tipoDocumento=?,numeroDocumento=?,idDepartamento=?,"
				+ "idProvincia=?,idDistrito=?,direccion=?,email=?,celular=? where idCliente=?";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setString(1,cliente.getNombres());
			pst.setString(2, cliente.getApePaterno());
			pst.setString(3, cliente.getApeMaterno());
			pst.setInt(4, cliente.getTipoDocumento());
			pst.setString(5, cliente.getNumero());
			pst.setInt(6, cliente.getIdDepartamento());
			pst.setInt(7, cliente.getIdProvincia());
			pst.setInt(8, cliente.getIdDistrito());
			pst.setString(9, cliente.getDireccion());
			pst.setString(10, cliente.getEmail());
			pst.setString(11, cliente.getCelular());
			pst.setInt(12,cliente.getId());
			cantidad = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion:"+e.getMessage());
		}
		return cantidad;
	}

	@Override
	public int eliminarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		int cantidad = 0;
		Connection cnx= null;
		PreparedStatement pst = null;
		String strSql="Delete from tb_clientes where idCliente=?";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst=cnx.prepareStatement(strSql);
			pst.setInt(1, cliente.getId());
			cantidad = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se suscito la siguiente excepcion: "+e.getMessage());
		}
		return cantidad;
	}

	@Override
	public ArrayList<ClienteDTO>listadoClienteFiltro(int tipo, String numero) {
		// TODO Auto-generated method stub
		ArrayList<ClienteDTO>listaCliente = new ArrayList<ClienteDTO>();
		Connection cnx = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strSql= "Select * from tb_clientes where tipoDocumento=? and numeroDocumento =?"; 
		
		try {
			cnx = MySQLConexion.getConexion();
			pst = cnx.prepareStatement(strSql);
			pst.setInt(1, tipo);
			pst.setString(2, numero);
			rs=pst.executeQuery();
			if(rs.next()) {
				ClienteDTO cliente=new ClienteDTO();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setApePaterno(rs.getString("apellidoPaterno"));
				cliente.setApeMaterno(rs.getString("apellidoMaterno"));
				cliente.setTipoDocumento(rs.getInt("tipoDocumento"));
				cliente.setNumero(rs.getString("numeroDocumento"));
				cliente.setIdDepartamento(rs.getInt("idDepartamento"));
				cliente.setIdProvincia(rs.getInt("idProvincia"));
				cliente.setIdDistrito(rs.getInt("idDistrito"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCelular(rs.getString("celular"));
				listaCliente.add(cliente);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("se suscito la siguiente excepcion:"+e.getMessage());
			e.printStackTrace();
		}
		
		return listaCliente;
	}

	@Override
	public ClienteDTO obtenerCliente(int idCliente) {
		// TODO Auto-generated method stub
		
		ClienteDTO cliente = null;
		PreparedStatement pst = null;
		Connection cnx = null;
		ResultSet rs = null;
		String strSql = "select * from tb_clientes where idCliente=?";
		
		try {
			cnx=MySQLConexion.getConexion();
			pst= cnx.prepareStatement(strSql);
			pst.setInt(1,idCliente);
			rs=pst.executeQuery();
			if(rs.next()) {
				cliente=new ClienteDTO();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setApePaterno(rs.getString("apellidoPaterno"));
				cliente.setApeMaterno(rs.getString("apellidoMaterno"));
				cliente.setTipoDocumento(rs.getInt("tipoDocumento"));
				cliente.setNumero(rs.getString("numeroDocumento"));
				cliente.setIdDepartamento(rs.getInt("idDepartamento"));
				cliente.setIdProvincia(rs.getInt("idProvincia"));
				cliente.setIdDistrito(rs.getInt("idDistrito"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCelular(rs.getString("celular"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("se suscito la siguiente excepcion:"+e.getMessage());
			e.printStackTrace();
		}
		return cliente;
	}

}
