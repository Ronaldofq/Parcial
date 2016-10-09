package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.Administrativo;
import com.dev.dto.Requerimiento;

public interface IRequerimientodao extends ICruddao<Requerimiento>,IRowmapper<Requerimiento>{
 List<Requerimiento> listarxadministrativo(Administrativo a) throws SQLException;
}
