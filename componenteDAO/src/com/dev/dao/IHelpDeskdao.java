package com.dev.dao;

import java.sql.SQLException;
import java.util.List;

import com.dev.dto.HelpDesk;

public interface IHelpDeskdao extends ICruddao<HelpDesk>,IRowmapper<HelpDesk>{
	HelpDesk autenticar(String correo, String password) throws SQLException;
	List<HelpDesk> listarxtipo(String tipo) throws SQLException;
}
