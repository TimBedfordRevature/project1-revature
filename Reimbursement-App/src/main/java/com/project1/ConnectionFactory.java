package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {};

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/project1";
            String username = "TimBedford";
            String password = "H@l0Infin1t2021";
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
