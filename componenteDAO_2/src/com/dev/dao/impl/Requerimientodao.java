package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IRequerimientodao;
import com.dev.ds.DBconnection;
import com.dev.dto.Administrativo;
import com.dev.dto.Requerimiento;

public class Requerimientodao implements IRequerimientodao{

	@Override
	public void create(Requerimiento o) throws SQLException {
		String insert = "{call sp_insert_requerimiento(?,?,?,?,?)}";

		Connection cn = DBconnection.getInstance(); //Era connection pro en la wada sale diferente

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getTipo());
		cs.setString(3, o.getDescripcion());
		cs.setString(4, o.getEstado());
		cs.setInt(5, o.getA().getIdempleado());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}
	}

	@Override
	public void update(Requerimiento o) throws SQLException {
		// TODO Auto-generated method stub		
		String update = "{call sp_update_categoria(?,?,?,?,?)}";
		Connection cn = DBconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(update);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdreq());
		cs.setString(3, o.getTipo());
		cs.setString(4, o.getDescripcion());
		cs.setString(5,o.getEstado());

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
	public Requerimiento get(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_get_requerimiento(?)}";
		Requerimiento r = new Requerimiento();
		Connection cn = DBconnection.getInstance();
		CallableStatement cs = cn.prepareCall(query);
		cs.setInt(1, id);
		ResultSet rs=cs.executeQuery();
		r = mapRow(rs);
		return r;
	}

	@Override
	public List<Requerimiento> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_requerimiento()}";
		List<Requerimiento> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public Requerimiento mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Requerimiento r=new Requerimiento();
		r.setIdreq(rs.getInt(1));
		r.setDescripcion(rs.getString(2));
		r.setEstado(rs.getString(4));
		r.setTipo(rs.getString(3));
		Administrativo a=new Administrativo();
		a.setIdempleado(rs.getInt(5));
		r.setA(a);
		return r;
	}

	@Override
	public List<Requerimiento> listarxadministrativo(Administrativo a) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_requexadmin(?)}";
		List<Requerimiento> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		cs.setInt(1, a.getIdempleado());
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}


}
