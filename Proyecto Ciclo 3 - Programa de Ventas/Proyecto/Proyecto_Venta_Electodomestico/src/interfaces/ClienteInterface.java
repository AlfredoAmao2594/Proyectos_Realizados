package interfaces;

import java.util.ArrayList;

import model.Cliente;
import model.Proveedor;

public interface ClienteInterface {
	
	public ArrayList<Cliente> listarClientes();
	public Cliente obtenerCliente(long id_cliente);
	public int registrarCliente(Cliente cliente);
	public int actualizarCliente(Cliente cliente);
	public int eliminarCliente(long id_cliente);
	public ArrayList<Cliente> buscarClientePorFiltro(Cliente cliente); 

}
