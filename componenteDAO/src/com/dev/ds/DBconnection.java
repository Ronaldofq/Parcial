package com.dev.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static final String url = "jdbc:mysql://localhost:3306/dbmesadeayuda";
	private static final String user = "root";
	private static final String passwd = "root";
	
	private static Connection con;
	
	private DBconnection(){}
	
	public static Connection connection()
	{
		if(con == null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,passwd);
			} catch (SQLException | ClassNotFoundException e) {
			}
		}
		return con;
	}	
}
