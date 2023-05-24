package beans;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 6090118726892034745L;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private int tipoDocumento;
	private String numeroDocumento;
	private String Usuario;
	private String contrasenia;
	private String tipoUsuario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.Usuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
