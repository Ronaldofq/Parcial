package com.dev.dao;

import java.sql.SQLException;

import com.dev.dto.Empleado;

public interface IEmpleadodao extends ICruddao<Empleado>,IRowmapper<Empleado>{

	Empleado autenticar(String correo, String password) throws SQLException;
}
