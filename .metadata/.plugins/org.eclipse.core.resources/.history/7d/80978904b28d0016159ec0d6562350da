package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IAsignaciondao;
import com.dev.ds.DBconnection;
import com.dev.dto.Asignacion;
import com.dev.dto.HelpDesk;
import com.dev.dto.Requerimiento;

public class Asignaciondao implements IAsignaciondao{

	@Override
	public void create(Asignacion o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_asignacion(?,?,?)}";

		Connection cn = DBconnection.getInstance(); //Era connection pro en la wada sale diferente

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getH().getIdempleado());
		cs.setInt(3, o.getR().getIdreq());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}
	
	}

	@Override
	public void update(Asignacion o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Asignacion get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asignacion> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_asignacion()}";
		List<Asignacion> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public Asignacion mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Asignacion a=new Asignacion();
		Requerimiento r=new Requerimiento();
		HelpDesk h=new HelpDesk();
		r.setIdreq(rs.getInt(1));
		h.setIdempleado(rs.getInt(2));
		a.setH(h);
		a.setR(r);
		return a;
	}


}
