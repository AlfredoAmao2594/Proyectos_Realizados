package interfaces;

import java.util.ArrayList;

import model.Cliente;
import model.Ticket;

public interface TicketInterface {

	public ArrayList<Ticket> listarTicket();
	public Ticket obtenerTicket(String numero);
	public int registrarTicket(Ticket ticket);
	public int actualizarTicket(Ticket ticket);
	public int eliminarTicket(String ticket);
	public String generarNumeroTicket(); 
	public ArrayList<Ticket> listarTicketPorEstado(int estado);
	public ArrayList<Ticket> buscarTicketPorFiltro(Ticket ticket); 
	public int actualizarEstadoTicket(ArrayList<Ticket> ticket);
	
}
