package it.begear.Banca.dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionManager {
	
	public static Connection getConnection() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/banca?useSSL=false&serverTimezone=UTC";
		final String user="root";
		final String password="root";
		return DriverManager.getConnection(url,user,password);
		
	}
	
}
