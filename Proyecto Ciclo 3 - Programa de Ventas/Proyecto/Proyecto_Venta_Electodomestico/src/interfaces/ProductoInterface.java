package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {

	public ArrayList<Producto> listarProducto();
	public Producto obtenerProducto(int id_producto);
	public int registrarProducto(Producto producto);
	public int actualizarProducto(Producto producto);
	public int eliminarProducto(int id_producto);
	public ArrayList<Producto> buscarProductoPorFiltro(Producto producto); 
}
