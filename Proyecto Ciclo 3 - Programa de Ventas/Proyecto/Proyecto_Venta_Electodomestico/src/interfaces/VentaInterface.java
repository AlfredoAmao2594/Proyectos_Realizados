package interfaces;

import java.util.ArrayList;

import model.ComprobantePagoCab;
import model.ComprobantePagoDetalle;

public interface VentaInterface {

	public ArrayList<ComprobantePagoCab> listarComrpobanteVentas();
	public String generarNumeroFactura();
	public int registrarBoleta(ComprobantePagoCab factura, ArrayList<ComprobantePagoDetalle> facturaDetalle);
	public ArrayList<ComprobantePagoCab> buscarComprobantePorFiltro(ComprobantePagoCab comprobante);
}
