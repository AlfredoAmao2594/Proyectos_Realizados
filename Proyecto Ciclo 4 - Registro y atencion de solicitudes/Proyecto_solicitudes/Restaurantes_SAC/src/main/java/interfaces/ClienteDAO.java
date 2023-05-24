package interfaces;

import java.util.ArrayList;

import beans.ClienteDTO;

public interface ClienteDAO {

	public int agregarCliente(ClienteDTO cliente);
	public ArrayList<ClienteDTO>listadoClienteFiltro(int tipo , String numero);
	public int actualizarCliente(ClienteDTO cliente);
	public int eliminarCliente (ClienteDTO cliente);
	public ClienteDTO obtenerCliente(int idCliente);
}
