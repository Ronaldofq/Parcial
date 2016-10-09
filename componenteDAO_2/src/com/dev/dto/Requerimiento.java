package com.dev.dto;

public class Requerimiento {

	private int idreq;
	private String tipo;
	private String descripcion;
	private String estado;
	
	private Administrativo a;
	
	public Administrativo getA() {
		return a;
	}
	public void setA(Administrativo a) {
		this.a = a;
	}
	public int getIdreq() {
		return idreq;
	}
	public void setIdreq(int idreq) {
		this.idreq = idreq;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
