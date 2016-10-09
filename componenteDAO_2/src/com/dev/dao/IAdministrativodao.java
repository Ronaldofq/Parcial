package com.dev.dao;

import java.sql.SQLException;

import com.dev.dto.Administrativo;


public interface IAdministrativodao extends ICruddao<Administrativo>,IRowmapper<Administrativo>{
	
	Administrativo autenticar(String correo, String password) throws SQLException;
}
