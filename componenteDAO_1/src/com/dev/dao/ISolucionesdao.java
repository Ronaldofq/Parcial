package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Soluciones;

public interface ISolucionesdao extends ICruddao<Soluciones>,IRowmapper<Soluciones>{
	
	List<Soluciones> listarSoluciones() throws SQLException;
}
