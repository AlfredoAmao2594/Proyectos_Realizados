package model;

public class ComprobantePagoCab {

	private String numeroFactura;
	private String fechaFact	;
	private int codigo_comp;
	private long idCliente;
	private double baseImponible;
	private double igv;
	private double totalCompro;
	
	public double getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getFechaFact() {
		return fechaFact;
	}
	public void setFechaFact(String fechaFact) {
		this.fechaFact = fechaFact;
	}
	public int getCodigo_comp() {
		return codigo_comp;
	}
	public void setCodigo_comp(int codigo_comp) {
		this.codigo_comp = codigo_comp;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public double getTotalCompro() {
		return totalCompro;
	}
	public void setTotalCompro(double totalCompro) {
		this.totalCompro = totalCompro;
	}

}
