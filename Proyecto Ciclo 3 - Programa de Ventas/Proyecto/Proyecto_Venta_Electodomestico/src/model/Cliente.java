package model;

public class Cliente {
	
	private long id_cliente;
	private int codigo_doc;
	private String nombre_cliente;
	private String direccion_cliente;
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
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getCodigo_doc() {
		return codigo_doc;
	}
	public void setCodigo_doc(int codigo_doc) {
		this.codigo_doc = codigo_doc;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	
	

}
