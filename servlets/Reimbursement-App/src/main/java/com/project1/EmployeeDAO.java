package com.project1;


import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	boolean verifyUser(String email, String password) throws SQLException;
//	void viewTickets(String email) throws SQLException;
//	void addTicket(String email, double amount, String type, String description) throws SQLException;
//	void viewAllTickets() throws SQLException;
//	void viewAllPendings() throws SQLException;
//	void viewAllApproved() throws SQLException;
//	void viewAllRejected() throws SQLException;
	String getEmployeeName(String email) throws SQLException;

}

