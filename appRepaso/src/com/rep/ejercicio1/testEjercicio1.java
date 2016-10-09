	package com.rep.ejercicio1;

import java.util.List;

public class testEjercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorDepartamento gp = new GestorDepartamento();
		GestorEmpleado ge = new GestorEmpleado();
		System.out.println("Registro Departamento");
		Departamento d = new Departamento();
		d.setCodigo(123);
		d.setNombre("Departamento 1");
		d.setLocalizacion("Algun lugar de la tierra");
		gp.registrarDepartamento(d);
		System.out.println("Todo es felicidad :) lo hiciste bien");
		
		System.out.println("Listado de Departamento");
		List<Departamento> ldep = gp.listarDepartamentos();
		for (Departamento departamento : ldep) 
		{
			System.out.println("Departamento="+departamento.getNombre());
		}
		
		System.out.println("Registro Empleado");
		Empleado e=new Empleado();
		e.setCodigo(321);
		e.setNombre("Empleado 1");
		e.setSueldo(1230);
		e.setDepartamento(d); 
		
		ge.registrarEmpleado(e);
		System.out.println("Eres lo maximo :) lo hiciste bien");
		
		System.out.println("Listado de Empleado");
		List<Empleado> lemp=ge.listarEmpleados();
		for (Empleado empleado : lemp) 
		{
			System.out.println("Empleado="+empleado.getNombre()+" Departamento="+empleado.getDepartamento().getNombre());
		}
		}
	}

