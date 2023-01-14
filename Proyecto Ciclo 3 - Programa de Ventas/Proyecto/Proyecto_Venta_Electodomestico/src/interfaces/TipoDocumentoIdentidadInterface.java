package interfaces;

import java.util.ArrayList;

import model.TipoDocumentoIdentidad;

public interface TipoDocumentoIdentidadInterface {

	public ArrayList<TipoDocumentoIdentidad> listarTipoDocumentoIdentidad();
	public TipoDocumentoIdentidad obtenerDocumentoIdentidad(int codigo);
	public int registrarDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad);
	public int actualizarDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad);
	public int eliminarDocumentoIdentidad(int codigo);
}
