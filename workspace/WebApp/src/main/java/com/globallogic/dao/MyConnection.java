package com.globallogic.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public Connection getConnection()
	{
		 Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/buddy";
			 con = DriverManager.getConnection(url, username, password);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return con;
	}
	
}
