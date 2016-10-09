package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Requerimiento;
import com.dev.dto.Solucion;

public interface ISoluciondao extends ICruddao<Solucion>,IRowmapper<Solucion>{
	
	List<Solucion> listarSolucionesxrequerimiento(Requerimiento r) throws SQLException;
}
