package com.adt;

import java.sql.*;

public class GestorConexiones {
    public static Connection getMySQL_Connection(String database) {
		final String DRIVER = "org.mariadb.jdbc.Driver";
		final String URL = "jdbc:mariadb://localhost:3306/"+database;
		final String LOGIN = "root";
		final String PASSWORD = "1234";
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);	
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver: " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());

		}

		return con;
	}
}
