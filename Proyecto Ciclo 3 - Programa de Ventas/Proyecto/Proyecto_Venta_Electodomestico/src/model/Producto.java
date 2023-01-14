package model;

public class Producto {
	
	private int id_producto;
	private String detalle;
	private String marca;
	private double precio;
	private long id_proveedor;
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	
	
	

}
