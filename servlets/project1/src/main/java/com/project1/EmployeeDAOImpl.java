package com.project1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Statement statement = null;
    private static Connection connection = null;
    
    public void EmployeeDAOImpl() throws ClassNotFoundException {
    	try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    @Override
    public void verifyUser(String email, String password) {
    	try {
        String sql = "select Email, Password from __Table__";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String emaildb = resultSet.getString(1);
            String passworddb = resultSet.getString(2);
            if (emaildb.equals(email) && passworddb.equals(password)) {
                __Main__.validLogin = true;
                break;
            }
        }
        if (__Main.validLogin__ == false && __Main.validEmpLogin__ == false)
            System.out.println("Incorrect email/password, try again");
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
    }

	@Override
	public void viewTickets(String name) {
		// TODO Auto-generated method stub
		try {
		String sql = "select * from __Table__  where TicketOwner = " + name;
        try {
			this.connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Ticket ticket = new Ticket();
        
        while (resultSet.next()) {
           
            int ticketNumber = resultSet.getInt(2);
            String ticketType = resultSet.getString(3);
            double amount = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            String status = resultSet.getString(6);
            
            ticket.setTicketOwner(name);
            ticket.setTicketNumber(ticketNumber);
            ticket.setTicketType(ticketType);
            ticket.setAmount(amount);
            ticket.setDescription(description);
            ticket.setStatus(status);

            System.out.println(status + ": Ticket number " + ticketNumber + " for " + ticketType + " that cost " 
            + amount + ". " + description);
        }
		
		} catch (SQLException e) {
    	e.printStackTrace();
		}
	}

	@Override
	public void addTicket(String email, double amount, String type, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewAllTickets() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from __Table__ ";
		    try {
				this.connection = ConnectionFactory.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery(sql);
		    Ticket ticket = new Ticket();
		        
		    while (resultSet.next()) {
		           
		    String ticketOwner = resultSet.getString(1);
		    int ticketNumber = resultSet.getInt(2);
		    String ticketType = resultSet.getString(3);
		    double amount = resultSet.getDouble(4);
		    String description = resultSet.getString(5);
		    String status = resultSet.getString(6);
		            
		    ticket.setTicketOwner(ticketOwner);
		    ticket.setTicketNumber(ticketNumber);
		    ticket.setTicketType(ticketType);
		    ticket.setAmount(amount);
		    ticket.setDescription(description);
		    ticket.setStatus(status);

		    System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
		    + ticketType + " that cost " + amount + ". " + description);
		        }
		}
		catch (SQLException e) {
    	e.printStackTrace();
		}
	}

	@Override
	public void viewAllPendings() {
		// TODO Auto-generated method stub
		try {
		String sql = "select * from __Table__ where Status = 'pending'";
        try {
			this.connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Ticket ticket = new Ticket();
        
        while (resultSet.next()) {
           
        	String ticketOwner = resultSet.getString(1);
        	int ticketNumber = resultSet.getInt(2);
            String ticketType = resultSet.getString(3);
            double amount = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            String status = resultSet.getString(6);
            
            ticket.setTicketOwner(ticketOwner);
            ticket.setTicketNumber(ticketNumber);
            ticket.setTicketType(ticketType);
            ticket.setAmount(amount);
            ticket.setDescription(description);
            ticket.setStatus(status);

            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
            + ticketType + " that cost " + amount + ". " + description);
        }
		} catch (SQLException e) {
    	e.printStackTrace();
		}
	}

	@Override
	public void viewAllApproved() {
		// TODO Auto-generated method stub
		try {
		String sql = "select * from __Table__ where Status = 'approved'";
        try {
			this.connection = ConnectionFactory.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Ticket ticket = new Ticket();
        
        
        while (resultSet.next()) {
           
        	String ticketOwner = resultSet.getString(1);
        	int ticketNumber = resultSet.getInt(2);
            String ticketType = resultSet.getString(3);
            double amount = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            String status = resultSet.getString(6);
            
            ticket.setTicketOwner(ticketOwner);
            ticket.setTicketNumber(ticketNumber);
            ticket.setTicketType(ticketType);
            ticket.setAmount(amount);
            ticket.setDescription(description);
            ticket.setStatus(status);

            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
            + ticketType + " that cost " + amount + ". " + description);
        }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}

	@Override
	public void viewAllRejected() {
		// TODO Auto-generated method stub
		try {
		String sql = "select * from __Table__ where Status = 'rejected'";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Ticket ticket = new Ticket();
        
        while (resultSet.next()) {
           
        	String ticketOwner = resultSet.getString(1);
        	int ticketNumber = resultSet.getInt(2);
            String ticketType = resultSet.getString(3);
            double amount = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            String status = resultSet.getString(6);
            
            ticket.setTicketOwner(ticketOwner);
            ticket.setTicketNumber(ticketNumber);
            ticket.setTicketType(ticketType);
            ticket.setAmount(amount);
            ticket.setDescription(description);
            ticket.setStatus(status);

            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
            + ticketType + " that cost " + amount + ". " + description);
        }
		
		} catch (SQLException e) {
    	e.printStackTrace();
	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	} 
}