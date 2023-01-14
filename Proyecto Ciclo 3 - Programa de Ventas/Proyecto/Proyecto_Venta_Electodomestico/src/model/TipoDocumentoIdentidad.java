package model;

public class TipoDocumentoIdentidad {
	
	int codigo;
	String detalle;
	
	public TipoDocumentoIdentidad() {
		
	}
		
	public TipoDocumentoIdentidad(int codigo, String detalle) {
		
		this.codigo = codigo;
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Override
	public String toString() {
		return detalle;
	}
	
	

}
