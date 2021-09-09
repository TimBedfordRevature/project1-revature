package com.project1;


import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	boolean verifyUser(String email, String password) throws SQLException;
//	void viewTickets(String email) throws SQLException;
//	void addTicket(String email, double amount, String type, String description) throws SQLException;
	public void addTicket(int ticketOwnerId, String ticketType, double amount, String description, String status) throws SQLException;
//	void viewAllTickets() throws SQLException;
	public String viewAllPendings(int empId) throws SQLException;
	public String getJsonArray() throws SQLException;
//	void viewAllApproved() throws SQLException;
//	void viewAllRejected() throws SQLException;
	public String getEmployeeName(String email) throws SQLException;
	public int getEmployeeId(String email) throws SQLException;

}

