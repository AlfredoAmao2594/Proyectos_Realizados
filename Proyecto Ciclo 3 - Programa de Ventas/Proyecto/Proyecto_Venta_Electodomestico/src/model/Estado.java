package model;

public class Estado {
	
	int codEstado;
	String desEstado;
	
	public Estado(){
		 
	}
	
	public Estado(int codEstado, String desEstado) {
		this.codEstado = codEstado;
		this.desEstado = desEstado;
	}

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public String getDesEstado() {
		return desEstado;
	}

	public void setDesEstado(String desEstado) {
		this.desEstado = desEstado;
	}
	@Override
	public String toString() {
	    return desEstado;
	  }
	

}
