package model;

public class Ticket {
	
	private String numero_Ticket;
	private String fechaTick;
	private int id_producto;
	private String detalle_producto;
	private double precio;
	private String id_vendedor;
	private int cantidad;
	private int codEstado;
	
	public String getNumero_Ticket() {
		return numero_Ticket;
	}
	public void setNumero_Ticket(String numero_Ticket) {
		this.numero_Ticket = numero_Ticket;
	}
	public String getFechaTick() {
		return fechaTick;
	}
	public void setFechaTick(String fechaTick) {
		this.fechaTick = fechaTick;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getDetalle_producto() {
		return detalle_producto;
	}
	public void setDetalle_producto(String detalle_producto) {
		this.detalle_producto = detalle_producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getId_vendedor() {
		return id_vendedor;
	}
	public void setId_vendedor(String id_vendedor) {
		this.id_vendedor = id_vendedor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getcodEstado() {
		return codEstado;
	}
	public void setEstado(int codEstado) {
		this.codEstado = codEstado;
	}
	
	
	
	
	

}
