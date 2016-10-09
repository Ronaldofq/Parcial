package com.dev.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.dao.IHelpDeskdao;
import com.dev.ds.DBconnection;
import com.dev.dto.HelpDesk;

public class HelpDeskdao implements IHelpDeskdao{

	@Override
	public void create(HelpDesk o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_helpdesk(?,?,?,?,?)}";

		Connection cn = DBconnection.getInstance(); //Era connection pro en la wada sale diferente

		CallableStatement cs = cn.prepareCall(insert);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombre());
		cs.setString(3, o.getUsuario());
		cs.setString(4, o.getPassword());
		cs.setString(5, o.getTipo());
		
		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;
		if (!estado.equals("ok")) {
			throw new SQLException();
		}
	}

	@Override
	public void update(HelpDesk o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_update_helpdesk(?,?,?,?,?)}";
		Connection cn = DBconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, o.getIdempleado());
		cs.setString(3, o.getNombre());
		cs.setString(4, o.getPassword());
		cs.setString(5, o.getTipo());

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
		
		String delete = "{call sp_delete_categoria(?,?)}";
		Connection cn = DBconnection.getInstance();
		cn.setAutoCommit(true);

		CallableStatement cs = cn.prepareCall(delete);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setInt(2, id);

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException();
		}
	}

	@Override
	public HelpDesk get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelpDesk> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_helpdesk()}";
		List<HelpDesk> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

	@Override
	public HelpDesk mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		HelpDesk h=new HelpDesk();
		h.setIdempleado(rs.getInt(1));
		h.setNombre(rs.getString(2));
		h.setUsuario(rs.getString(3));
		h.setTipo(rs.getString(4));
		return h;
	}



	@Override
	public HelpDesk autenticar(String correo, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_autenticar_helpdesk(?,?)}";

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

	@Override
	public List<HelpDesk> listarxtipo(String tipo) throws SQLException {
		// TODO Auto-generated method stub
		String query = "{call sp_list_helpdeskxtipo(?)}";
		List<HelpDesk> lista=new ArrayList<>();

		Connection cn =  DBconnection.getInstance();

		CallableStatement cs = cn.prepareCall(query);
		cs.setString(1, tipo);
		ResultSet rs=cs.executeQuery();
		while(rs.next()){
			lista.add(mapRow(rs));
		}
		return lista;
	}

}
