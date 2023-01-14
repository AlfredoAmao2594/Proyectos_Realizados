package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import interfaces.VentaInterface;
import model.ComprobantePagoCab;
import model.ComprobantePagoDetalle;
import model.Ticket;
import utils.MySQLConexion;

public class GestionVenta implements VentaInterface{

	@Override
	public ArrayList<ComprobantePagoCab> listarComrpobanteVentas() {
		ArrayList<ComprobantePagoCab> lista = new ArrayList<ComprobantePagoCab>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   
		   con = MySQLConexion.getConexion();
		  
		   String sql = " select numero_factura, fecha, codigo_comp, id_cliente,base_comprobante,igv_comprobante, total_comprobante from comprobante_pago_cab "; 

		   pst = con.prepareStatement(sql);	 
		
		   rs = pst.executeQuery(); 

		   while (rs.next()){ 
			   ComprobantePagoCab factura = new ComprobantePagoCab(); 
			   factura.setNumeroFactura(rs.getString(1));
			   factura.setFechaFact(rs.getString(2));
			   factura.setCodigo_comp(rs.getInt(3));
			   factura.setIdCliente(rs.getLong(4));
			   factura.setBaseImponible(rs.getDouble(5));
			   factura.setIgv(rs.getDouble(6));
			   factura.setTotalCompro(rs.getDouble(7));
			   lista.add(factura);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try {//Paso 8 : cerrar los objetos 
				  if (rs!= null)    rs.close();
			      if (pst != null) 	pst.close();
			      if (con != null) 	con.close();
			   } catch (SQLException e) {
			      System.out.println("Error al cerrar conexión");
			   }
		}
		//Paso 9 : Se retorna el  objeto libro 
		return lista;
	}

	@Override
	public String generarNumeroFactura() {
		ArrayList<ComprobantePagoCab> listaFactura = listarComrpobanteVentas();
		 DecimalFormat df = new DecimalFormat("0000");
		 int codigo=1;
		 if (listaFactura!=null && listaFactura.size()!=0){
			ComprobantePagoCab factura= listarComrpobanteVentas().get(listaFactura.size()-1); 
			codigo=Integer.parseInt(factura.getNumeroFactura().substring(1)) + 1;
		 } 
		return "F"+df.format(codigo);
	}

	@Override
	public int registrarBoleta(ComprobantePagoCab factura, ArrayList<ComprobantePagoDetalle> facturaDetalle) {
		
				int resultado = 0;
				Connection con = null;
				PreparedStatement pstCab = null;
				PreparedStatement pstDet = null;
				try {
					 
					con = MySQLConexion.getConexion();
					
					con.setAutoCommit(false);
					
					String sqlCab = " insert into comprobante_pago_cab (numero_factura, fecha, codigo_comp, id_cliente, base_comprobante,igv_comprobante,total_comprobante) "+
							" values (?, ?, ?, ?, ?, ?,?) ";
					
					pstCab = con.prepareStatement(sqlCab);
				
					pstCab.setString(1, factura.getNumeroFactura());
					pstCab.setString(2, factura.getFechaFact());
					pstCab.setInt(3, factura.getCodigo_comp());
					pstCab.setLong(4, factura.getIdCliente());
					pstCab.setDouble(5, factura.getBaseImponible());
					pstCab.setDouble(6, factura.getIgv()); 
					pstCab.setDouble(7, factura.getTotalCompro());
						   
					resultado = pstCab.executeUpdate(); 
				
					String sqlDet = " insert into comprobante_pago_deta (numero_factura, numero_ticket, id_producto, deta_producto, cantidad, precio, importe) "+
									" values (?, ?, ?, ?, ?, ?, ?) ";
				
					for (ComprobantePagoDetalle facDet : facturaDetalle) {
						
						pstDet= con.prepareStatement(sqlDet);
						pstDet.setString(1, facDet.getNumeroFactura());
						pstDet.setString(2, facDet.getNumeroTicket());
						pstDet.setInt(3, facDet.getIdProducto());
						pstDet.setString(4, facDet.getDetalleProducto());
						pstDet.setInt(5, facDet.getCantidad()); 
						pstDet.setDouble(6, facDet.getPrecio());
						pstDet.setDouble(7,  facDet.getImporte());
						
						resultado = pstDet.executeUpdate(); 
					}
					
					con.commit();
			 
				} catch (Exception e) {
						
						try {
							con.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					   System.out.println("Error en la sentencia " + e.getMessage());
				} finally {
					  try { 
						      if (pstCab != null) pstCab.close();
						      if (pstDet != null) pstDet.close();
						      if (con != null) con.close();
						   } catch (SQLException e) {
							   System.out.println("Error al cerrar conexión: "+e.getMessage());
						   }
						}
			
				return resultado;  
	}

	@Override
	public ArrayList<ComprobantePagoCab> buscarComprobantePorFiltro(ComprobantePagoCab comprobante) {
		
		ArrayList<ComprobantePagoCab> lista = new ArrayList<ComprobantePagoCab>();
		ResultSet rs = null; 
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
		   con = MySQLConexion.getConexion();

		   String sql = " select numero_factura, fecha, codigo_comp, id_cliente, base_comprobante,igv_comprobante, total_comprobante from comprobante_pago_cab "+
				   		" where numero_factura like CONCAT ('%',?,'%' ) AND fecha like CONCAT ('%',?,'%') "; 
		 
		   pst = con.prepareStatement(sql);	 
		   
		   pst.setString(1, comprobante.getNumeroFactura());
		   pst.setString(2, comprobante.getFechaFact());
		   
		   rs = pst.executeQuery(); 
		   
		   while (rs.next()){ 
			   ComprobantePagoCab factura = new ComprobantePagoCab(); 
			   factura.setNumeroFactura(rs.getString(1));
			   factura.setFechaFact(rs.getString(2));
			   factura.setCodigo_comp(rs.getInt(3));
			   factura.setIdCliente(rs.getLong(4));
			   factura.setBaseImponible(rs.getDouble(5));
			   factura.setIgv(rs.getDouble(6));
			   factura.setTotalCompro(rs.getDouble(7));
			   lista.add(factura);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
			  try {
				  if (rs!= null)    rs.close();
			      if (pst != null) 	pst.close();
			      if (con != null) 	con.close();
			   } catch (SQLException e) {
			      System.out.println("Error al cerrar conexión");
			   }
		}
		return lista;
	}

}
