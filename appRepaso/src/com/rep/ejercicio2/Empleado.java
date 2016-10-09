package com.rep.ejercicio2;

public abstract class Empleado {
	
	private int codigo;
	private String nombre;
	private double costoboni;
	
	public Empleado(int codigo, String nombre, double costoboni) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.costoboni = costoboni;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCostoboni() {
		return costoboni;
	}

	public void setCostoboni(double costoboni) {
		this.costoboni = costoboni;
	}
	
	public double CalcularBonificacion()
	{
		return costoboni*10;
	}
	
	public abstract double CalcularSueldo();
}
