package com.project1;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	void verifyUser(String email, String password);
	void viewTickets(String email);
	void addTicket(String email, double amount, String type, String description);
	void viewAllTickets();
	void viewAllPendings();
	void viewAllApproved();
	void viewAllRejected();

}

