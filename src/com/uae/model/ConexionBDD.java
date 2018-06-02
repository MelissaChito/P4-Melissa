package com.uae.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBDD {

	private Connection connection;

	public ConexionBDD() {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			String jdbcUrl = "jdbc:mysql://";
			String user = "root";
			String password = "1234";
			String serverName = "localhost";
			String port = "3306";
			String databaseName = "lep3";
			
			try {
				Class.forName(driverName);
				connection = DriverManager.getConnection(jdbcUrl + serverName + ":" + port + "/" + databaseName, user,
						password);
				if (connection != null) {
					System.out.println("Conexion a BDD ha sido exitosa!");
				} else {
					System.out.println("Conexion a la BDD Fallida!");
				}
			} catch (Exception e) {
				System.out.println("Conexion a la BDD Fallida!");
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
