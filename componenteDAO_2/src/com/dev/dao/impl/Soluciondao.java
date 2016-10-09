package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.ISoluciondao;
import com.dev.ds.DBconnection;
import com.dev.dto.Requerimiento;
import com.dev.dto.Solucion;


public class Soluciondao implements ISoluciondao{

	@Override
	public void create(Solucion o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_solucion(?,?,?)}";

		Connection cn = DBconnection.getInstance(); //Era connection pro en la wada sale diferente

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getDescripcion());
		cs.setInt(3,o.getR().getIdreq() );

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}

	}

	@Override
	public void update(Solucion o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solucion get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solucion> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_solucion()}";
		List<Solucion> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public Solucion mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Solucion s=new Solucion();
		
		s.setIdsolucion(rs.getInt(1));
		s.setDescripcion(rs.getString(2));
		
		return s;
	}

	@Override
	public List<Solucion> listarSolucionesxrequerimiento(Requerimiento r) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_solucionxreque(?)}";
		List<Solucion> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		cs.setInt(1, r.getIdreq());
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
		
	}



	

}
