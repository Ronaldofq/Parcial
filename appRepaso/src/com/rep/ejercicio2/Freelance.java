package com.rep.ejercicio2;

public class Freelance extends Empleado {

	private int valor_hora;

	public Freelance(int codigo, String nombre, double costoboni, int valor_hora) {
		super(codigo, nombre, costoboni);		
		// TODO Auto-generated constructor stub
		this.valor_hora = valor_hora;
	}

	public int getValor_hora() {
		return valor_hora;
	}

	public void setValor_hora(int valor_hora) {
		this.valor_hora = valor_hora;
	}

	@Override
	public double CalcularSueldo() {
		// TODO Auto-generated method stub
		return valor_hora*50;
	}
	
	
}
