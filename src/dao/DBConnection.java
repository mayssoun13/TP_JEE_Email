package dao;

import java.sql.*;

public class DBConnection {
	private static final String db 		 = "userdb",
								user 	 = "postgres",
								password = "postgres",
								url 	 = "jdbc:postgresql://localhost/"+db;
	private static Connection conn ;
	
	private DBConnection() {}
	
	static {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}

}