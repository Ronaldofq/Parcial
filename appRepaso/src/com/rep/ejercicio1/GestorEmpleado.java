package com.rep.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleado {

private List<Empleado> lsempleados;
	
	public GestorEmpleado()
	{
		lsempleados = new ArrayList<>();
	}
	
	public void registrarEmpleado(Empleado e)
	{
		lsempleados.add(e);
	}
	
	public List<Empleado> listarEmpleados()
	{
		return lsempleados;
	}
}
