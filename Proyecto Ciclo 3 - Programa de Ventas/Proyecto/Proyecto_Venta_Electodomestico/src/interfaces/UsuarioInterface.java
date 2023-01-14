package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterface {
	
	public ArrayList<Usuario> listarUsuario();
	public Usuario obtenerUsuario(String id_vendedor);
	public int registrarUsuario(Usuario usuario);
	public int actualizarUsuario(Usuario usuario);
	public ArrayList<Usuario> buscarUsuarioPorFiltro(Usuario usuario); 

}
