package br.cefet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection = null;
	private static ConnectionFactory instance;
	
	private ConnectionFactory() {
		final String DB_URL = "jdbc:mysql://localhost/dbtravelsystem";
		final String USERNAME = "root";
		final String PASSWORD = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection...");
			this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch(SQLException e) {
			System.out.println("Error" + e.getMessage());
		} catch(ClassNotFoundException e) {
			System.out.println("Error on find class" + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		
		return instance;
	}
}
