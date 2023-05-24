package interfaces;

import java.util.ArrayList;

import beans.UsuarioDTO;

public interface UsuarioDAO {

	public UsuarioDTO validarLogueo(String idUsuario, String contrasenia);
	public int agregarUsuario(UsuarioDTO usuario);
}
