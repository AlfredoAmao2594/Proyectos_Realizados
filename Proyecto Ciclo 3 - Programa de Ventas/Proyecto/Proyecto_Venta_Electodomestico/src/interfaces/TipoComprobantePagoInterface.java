package interfaces;

import java.util.ArrayList;

import model.TipoComprobantePago;

public interface TipoComprobantePagoInterface {

	public ArrayList<TipoComprobantePago> listarComprobantePago();
	public TipoComprobantePago obtenerComprobantePago(int codigo);
	public int registrarComprobantePago(TipoComprobantePago tipoComprobantePago);
	public int actualizarComprobantePago(TipoComprobantePago tipoComprobantePago);
	public int eliminarComprobantePago(int codigo);
}
