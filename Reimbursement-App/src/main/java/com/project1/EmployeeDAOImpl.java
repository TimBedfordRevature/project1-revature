package com.project1;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Statement statement = null;
	Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    
    public EmployeeDAOImpl() throws ClassNotFoundException {
		try {
			this.connection = ConnectionFactory.getConnection();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
    
    @Override
    public boolean verifyUser(String _email, String _password) throws SQLException {
    	String sql = "select name from employees where email = ? AND password = ?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setString(1, _email);
    	preparedStatement.setString(2, _password);
    	resultSet = preparedStatement.executeQuery();

    	boolean flag;

    	if(resultSet.next()) {
    		flag = true;
    	}else {
    		flag = false;
    	}

    	return flag;
    	
//    	while(resultSet.next()) {
//    		String email = resultSet.getString(1);
//    		String password = resultSet.getString(2);
//    		if(email.equals(_email) && password.equals(_password)) {
//    			flag = true;
//    		}else {
//    			flag = false;
//    		}
//    	}
//    	try {
//        String sql = "select Email, Password from __Table__";
//        this.connection = ConnectionFactory.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()) {
//            String emaildb = resultSet.getString(1);
//            String passworddb = resultSet.getString(2);
//            if (emaildb.equals(email) && passworddb.equals(password)) {
//                __Main__.validLogin = true;
//                break;
//            }
//        }
//        if (__Main.validLogin__ == false && __Main.validEmpLogin__ == false)
//            System.out.println("Incorrect email/password, try again");
//    	} catch (SQLException e) {
//    	e.printStackTrace();
//    	}
    }
    
    @Override
   public String viewAllPendings(int _empId) throws SQLException{
    	String sql = "select * from tickets where status = 'pending' AND ticket_owner_id = ?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, _empId);
    	resultSet = preparedStatement.executeQuery();
    	
    	 List<Ticket> tickets = new ArrayList<>();
    	 String viewTickets = "";
       while (resultSet.next()) {
           int ticketNumber = resultSet.getInt(1);
           int empId = resultSet.getInt(2);
           String ticketType = resultSet.getString(3);
           double amount = resultSet.getDouble(4);
           String description = resultSet.getString(5);
           String status = resultSet.getString(6);
           tickets.add(new Ticket(ticketNumber, empId, ticketType, amount, description, status));
           viewTickets += " <tr>\r\n"
           		+ "                    <td>"+ ticketNumber +"</td>\r\n"
           		+ "                    <td>"+ empId +"</td>\r\n"
           		+ "                    <td>"+ ticketType + "</td>\r\n"
           		+ "                    <td>$"+ amount +"</td>\r\n"
           		+ "                    <td>"+ status + "</td>\r\n"
           		+ "                    <td style=\"white-space: nowrap; text-overflow:ellipsis; overflow: hidden; max-width:1px;\">"+ description +" </td>\r\n"
           		+ "                    \r\n"
           		+ "                </tr>";
       }
       return viewTickets;
    	
    }

    
    
    
//	@Override
//	public void viewTickets(String name) {
//		// TODO Auto-generated method stub
//		try {
//		String sql = "select * from __Table__  where TicketOwner = " + name;
//        try {
//			this.connection = ConnectionFactory.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        Ticket ticket = new Ticket();
//        
//        while (resultSet.next()) {
//           
//            int ticketNumber = resultSet.getInt(2);
//            String ticketType = resultSet.getString(3);
//            double amount = resultSet.getDouble(4);
//            String description = resultSet.getString(5);
//            String status = resultSet.getString(6);
//            
//            ticket.setTicketOwnerId(name);
//            ticket.setTicketNumber(ticketNumber);
//            ticket.setTicketType(ticketType);
//            ticket.setAmount(amount);
//            ticket.setDescription(description);
//            ticket.setStatus(status);
//
//            System.out.println(status + ": Ticket number " + ticketNumber + " for " + ticketType + " that cost " 
//            + amount + ". " + description);
//        }
//		
//		} catch (SQLException e) {
//    	e.printStackTrace();
//		}
//	}
//
    @Override
	public void addTicket(int ticketOwnerId, String ticketType, double amount, String description, String status) throws SQLException {
        String sql = "insert into tickets (ticket_owner_id, ticket_type, amount, description, status) values (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticketOwnerId);
        preparedStatement.setString(2, ticketType);
        preparedStatement.setDouble(3, amount);
        preparedStatement.setString(4, description);
        preparedStatement.setString(5, status);
        preparedStatement.executeUpdate();
        

//        try {
//            String sql = "insert into tickets (TicketOwner, TicketType, Amount, Description"
//                    + ", Status, TimeSubmit) values (?,?,?,?,?,now())";
//            //ticketnumber autoincremented
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            //preparedStatement.setInt(2, LoginServlet.LoginEmployee.getEmployeeID());
//            // or preparedStatement.setInt(2, parseInt(cookieID));
//            preparedStatement.setString(3, type);
//            preparedStatement.setDouble(4, amount);
//            preparedStatement.setString(5, description);
//            preparedStatement.setString(6, "pending");
//            int count = preparedStatement.executeUpdate();
//            if (count > 0)
//                System.out.println("Ticket Saved!");
//            else
//                System.out.println("Ticket not Saved :(");
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
//
//	@Override
//	public void viewAllTickets() {
//		// TODO Auto-generated method stub
//		try {
//			String sql = "select * from __Table__ ";
//		    try {
//				this.connection = ConnectionFactory.getConnection();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    Statement statement = connection.createStatement();
//		    ResultSet resultSet = statement.executeQuery(sql);
//		    Ticket ticket = new Ticket();
//		        
//		    while (resultSet.next()) {
//		           
//		    String ticketOwner = resultSet.getString(1);
//		    int ticketNumber = resultSet.getInt(2);
//		    String ticketType = resultSet.getString(3);
//		    double amount = resultSet.getDouble(4);
//		    String description = resultSet.getString(5);
//		    String status = resultSet.getString(6);
//		            
//		    ticket.setTicketOwner(ticketOwner);
//		    ticket.setTicketNumber(ticketNumber);
//		    ticket.setTicketType(ticketType);
//		    ticket.setAmount(amount);
//		    ticket.setDescription(description);
//		    ticket.setStatus(status);
//
//		    System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
//		    + ticketType + " that cost " + amount + ". " + description);
//		        }
//		}
//		catch (SQLException e) {
//    	e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void viewAllPendings() {
//		// TODO Auto-generated method stub
//		try {
//		String sql = "select * from __Table__ where Status = 'pending'";
//        try {
//			this.connection = ConnectionFactory.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        Ticket ticket = new Ticket();
//        
//        while (resultSet.next()) {
//           
//        	String ticketOwner = resultSet.getString(1);
//        	int ticketNumber = resultSet.getInt(2);
//            String ticketType = resultSet.getString(3);
//            double amount = resultSet.getDouble(4);
//            String description = resultSet.getString(5);
//            String status = resultSet.getString(6);
//            
//            ticket.setTicketOwner(ticketOwner);
//            ticket.setTicketNumber(ticketNumber);
//            ticket.setTicketType(ticketType);
//            ticket.setAmount(amount);
//            ticket.setDescription(description);
//            ticket.setStatus(status);
//
//            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
//            + ticketType + " that cost " + amount + ". " + description);
//        }
//		} catch (SQLException e) {
//    	e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void viewAllApproved() {
//		// TODO Auto-generated method stub
//		try {
//		String sql = "select * from __Table__ where Status = 'approved'";
//        try {
//			this.connection = ConnectionFactory.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        Ticket ticket = new Ticket();
//        
//        
//        while (resultSet.next()) {
//           
//        	String ticketOwner = resultSet.getString(1);
//        	int ticketNumber = resultSet.getInt(2);
//            String ticketType = resultSet.getString(3);
//            double amount = resultSet.getDouble(4);
//            String description = resultSet.getString(5);
//            String status = resultSet.getString(6);
//            
//            ticket.setTicketOwner(ticketOwner);
//            ticket.setTicketNumber(ticketNumber);
//            ticket.setTicketType(ticketType);
//            ticket.setAmount(amount);
//            ticket.setDescription(description);
//            ticket.setStatus(status);
//
//            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
//            + ticketType + " that cost " + amount + ". " + description);
//        }
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        }
//	}
//
//	@Override
//	public void viewAllRejected() {
//		// TODO Auto-generated method stub
//		try {
//		String sql = "select * from __Table__ where Status = 'rejected'";
//        this.connection = ConnectionFactory.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        Ticket ticket = new Ticket();
//        
//        while (resultSet.next()) {
//           
//        	String ticketOwner = resultSet.getString(1);
//        	int ticketNumber = resultSet.getInt(2);
//            String ticketType = resultSet.getString(3);
//            double amount = resultSet.getDouble(4);
//            String description = resultSet.getString(5);
//            String status = resultSet.getString(6);
//            
//            ticket.setTicketOwner(ticketOwner);
//            ticket.setTicketNumber(ticketNumber);
//            ticket.setTicketType(ticketType);
//            ticket.setAmount(amount);
//            ticket.setDescription(description);
//            ticket.setStatus(status);
//
//            System.out.println(status + ": " + ticketOwner + "'s ticket of" + " ticket number " + ticketNumber + " for " 
//            + ticketType + " that cost " + amount + ". " + description);
//        }
//		
//		} catch (SQLException e) {
//    	e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
//	}
    
	@Override
	public int getEmployeeId(String email) throws SQLException {
    	String sql = "select emp_id from employees where email = ?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setString(1, email);
    	resultSet = preparedStatement.executeQuery();
    	
    	int name = 0;
    	if(resultSet.next()) {
    	name = resultSet.getInt(1);
    	}
		return name;
	} 
	

	@Override
	public String getEmployeeName(String email) throws SQLException {
    	String sql = "select name from employees where email = ?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setString(1, email);
    	resultSet = preparedStatement.executeQuery();
    	
    	String name = "";
    	if(resultSet.next()) {
    	name = resultSet.getString(1);
    	}
		return name;
	} 
}