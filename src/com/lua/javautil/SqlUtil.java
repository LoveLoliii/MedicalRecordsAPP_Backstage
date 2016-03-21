package com.lua.javautil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtil {
	private static String driveClassName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/medicalrecordsapp_backstage";
	private static String user = "root";
	private static String password = "root";

	static {
		try {
			Class.forName(driveClassName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
			
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return conn;
	}

}
