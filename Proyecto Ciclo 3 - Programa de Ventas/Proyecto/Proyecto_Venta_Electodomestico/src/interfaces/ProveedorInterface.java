package interfaces;

import java.util.ArrayList;

import model.Proveedor;

public interface ProveedorInterface {
	
	public ArrayList<Proveedor> listarProveedor();
	public Proveedor obtenerProveedor(long id_proveedor);
	public int registrarProveedor(Proveedor proveedor);
	public int actualizarProveedor(Proveedor proveedor);
	public int eliminarProveedor(long id_proveedor);
	public ArrayList<Proveedor> buscarProveedorPorFiltro(Proveedor proveedor); 

}
