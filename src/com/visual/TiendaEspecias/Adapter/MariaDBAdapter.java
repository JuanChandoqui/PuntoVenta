package com.visual.TiendaEspecias.Adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBAdapter {
	private static MariaDBAdapter instancia = null;
	private static Connection connection = null;
	
	private MariaDBAdapter() {
		
	}
	
	public static MariaDBAdapter getInstancia() {
		if (instancia == null) {
			instancia = new MariaDBAdapter();
			instancia.Connection();
		}
		
		return instancia;	
	}
	
	private void Connection() {		
		String connectionString = "jdbc:mariadb://localhost:3306/tienda";
		String user = "root";
		String password = "1234";
		try {
			connection = DriverManager.getConnection(connectionString, user, password);
			System.out.println(connection.getClass().getCanonicalName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
