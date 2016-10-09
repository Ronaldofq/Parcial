package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IAdministrativodao;
import com.dev.ds.DBconnection;
import com.dev.dto.Administrativo;
import com.dev.dto.Area;

public class Administrativodao implements IAdministrativodao{

	@Override
	public void create(Administrativo o) throws SQLException {
		String insert = "{call sp_insert_administrativo(?,?,?,?,?)}";

		Connection cn = DBconnection.getInstance(); //Era connection pro en la wada sale diferente

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getUsuario());
		cs.setString(4, o.getPassword());
		cs.setInt(5, o.getA().getIdarea());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}
		
	}

	@Override
	public void update(Administrativo o) throws SQLException {
		// TODO Auto-generated method stub		
		String insert = "{call sp_update_administrativo(?,?,?,?,?)}";
		Connection cn = DBconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdempleado());
		cs.setString(3, o.getNombre());
		cs.setString(4, o.getPassword());
		cs.setInt(5, o.getA().getIdarea());

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub		
	}

	@Override
	public Administrativo get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrativo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_administrativo()}";
		List<Administrativo> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public Administrativo mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Administrativo a=new Administrativo();
		Area ar = new Area();
		a.setIdempleado(rs.getInt(1));
		a.setNombre(rs.getString(2));
		a.setUsuario(rs.getString(3));
		ar.setNombre(rs.getString(4));
		a.setA(ar);
		return a;
	}



	@Override
	public Administrativo autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_autenticar_administrativo(?,?)}";

		Connection cn = DBconnection.getInstance();
		CallableStatement cs = cn.prepareCall(query);
		cs.setString(1, correo);
		cs.setString(2, password);

		ResultSet rs = cs.executeQuery();
		if (rs.next()) {
			mapRow(rs);
		}

		return mapRow(rs);
	}

}
