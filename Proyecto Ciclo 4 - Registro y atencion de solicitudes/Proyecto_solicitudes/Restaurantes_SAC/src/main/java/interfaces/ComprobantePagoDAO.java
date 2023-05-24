package interfaces;

import java.util.ArrayList;

import beans.ComprobantePagoDTO;

public interface ComprobantePagoDAO {
	
	public ComprobantePagoDTO obtenerComprobante(String tipo , int numero);

}
