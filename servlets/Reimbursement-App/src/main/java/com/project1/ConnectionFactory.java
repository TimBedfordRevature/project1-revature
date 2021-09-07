package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {};

    public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.project1.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/project1";
            String username = "TimBedford";
            String password = "H@l0Infin1t2021";
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
