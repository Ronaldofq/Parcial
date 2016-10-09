package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IAreadao;
import com.dev.ds.DBconnection;
import com.dev.dto.Area;


public class Areadao implements IAreadao{

	@Override
	public void create(Area o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_area(?,?)}";

		Connection cn = DBconnection.connection();

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}
	}

	@Override
	public void update(Area o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Area get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_area()}";
		List<Area> lista=new ArrayList<>();

		Connection cn =  DBconnection.connection();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public Area mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Area a = new Area();
		a.setIdarea(rs.getInt(1));
		a.setNombre(rs.getString(2));
		return a;
	}


}
