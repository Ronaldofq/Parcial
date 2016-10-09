package com.rep.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleado {

	private List<Empleado> lsEmpleado;

	public GestorEmpleado() {
		// TODO Auto-generated constructor stub
		lsEmpleado = new ArrayList<>();
	}
	
	public void registroEmpleado(Empleado e)
	{
		lsEmpleado.add(e);
	}
	
	public List<Empleado> listarEmpleados()
	{
		return lsEmpleado;
	}
}
