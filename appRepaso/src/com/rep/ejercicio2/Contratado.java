package com.rep.ejercicio2;

public class Contratado extends Empleado{
	
	private double sueldo;

	public Contratado(int codigo, String nombre, double costoboni, double sueldo) {
		super(codigo, nombre, costoboni);
		this.sueldo = sueldo;
		// TODO Auto-generated constructor stub
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public double CalcularSueldo()
	{
		return sueldo*40;
	}
}
