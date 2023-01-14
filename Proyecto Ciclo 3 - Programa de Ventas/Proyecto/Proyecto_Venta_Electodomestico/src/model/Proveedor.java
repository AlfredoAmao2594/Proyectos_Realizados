package model;

public class Proveedor {

	private long id_provedor;
	private String razon_social;
	private String direccion;
	private String telefono;
	private String correo;
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public long getId_provedor() {
		return id_provedor;
	}
	public void setId_provedor(long id_provedor) {
		this.id_provedor = id_provedor;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
