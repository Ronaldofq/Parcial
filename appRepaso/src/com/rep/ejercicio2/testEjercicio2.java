package com.rep.ejercicio2;

import java.util.List;

public class testEjercicio2 {
	
	public static void main(String[] args)
	{
		GestorEmpleado ge = new GestorEmpleado();
		Empleado e1 = new Contratado(123, "Nombre1", 123, 21);
		Empleado e2 = new Freelance(321, "Nombre2", 345, 3);
		
		ge.registroEmpleado(e1);
		ge.registroEmpleado(e2);
		List<Empleado> lsempleado = ge.listarEmpleados();
		for (Empleado empleado : lsempleado)
		{
			System.out.println("Nombre Empleado=" + empleado.getNombre());
			//Filtra el sueldo de los empleados contratados
			if (empleado instanceof Contratado) 
			{
				System.out.println(empleado.CalcularSueldo());
			}
		}
	}
}
