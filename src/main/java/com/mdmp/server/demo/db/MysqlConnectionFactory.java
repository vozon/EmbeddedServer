package com.mdmp.server.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnectionFactory {
	//private static final String connectionURL = ConfigurationManager.getDefaultConfig().getValue("hive.url");
	//private static final String connectionURL = "jdbc:mysql://localhost:3306/hello?characterEncoding=UTF-8";
	private static final String connectionURL = "jdbc:mysql://10.224.195.81:3306/mdmp?characterEncoding=UTF-8";
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String user = "johnny";
	private static final String pass = "pass";
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Connection testConnection = null;

	public static Connection getConnection() throws Exception {
		// testConnection is for test only
		return testConnection == null ? DriverManager.getConnection(connectionURL, user, pass) : testConnection;
	}
	
	void deconnSQL() {
		try {
			if (testConnection != null)
				testConnection.close();
		} catch (Exception e) {
			System.out.println("Error to close mysql connection£º");
			e.printStackTrace();
		}
	}
}
