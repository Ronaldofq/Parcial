package com.rep.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestorDepartamento {

	private List<Departamento> lsdepartamento;
	
	public GestorDepartamento()
	{
		lsdepartamento = new ArrayList<>();
	}
	
	public void registrarDepartamento(Departamento d)
	{
		lsdepartamento.add(d);
	}
	
	public List<Departamento> listarDepartamentos()
	{
		return lsdepartamento;
	}
}
