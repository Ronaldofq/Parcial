package com.dev.dto;

public class Solucion {

	private int idsolucion;
	private String descripcion;
	private Requerimiento r;
	
	
	public Requerimiento getR() {
		return r;
	}
	public void setR(Requerimiento r) {
		this.r = r;
	}
	public int getIdsolucion() {
		return idsolucion;
	}
	public void setIdsolucion(int idsolucion) {
		this.idsolucion = idsolucion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
	
}
