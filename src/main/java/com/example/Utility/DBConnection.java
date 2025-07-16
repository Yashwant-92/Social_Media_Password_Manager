package com.example.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection;

	static String url = "jdbc:mysql://localhost:3306/passwordManagerDB";
	static String username = "root";
	static String password = "root";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error Connection not established..");
			e.printStackTrace();
		}
		return connection;

	}

}
