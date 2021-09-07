package com.project1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReimbursmentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String ticketType = request.getParameter("ticketType");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		
		Cookie[] cookieE = request.getCookies();
		String email = cookieE[0].getValue();
		
		Cookie[] cookieP = request.getCookies();
		String password = cookieP[0].getValue();
		
		Cookie[] cookieN = request.getCookies();
		String name = cookieN[0].getValue();
		
		try {
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			int empId = dao.getEmployeeId(email);
			
			dao.addTicket(empId, ticketType, amount, description, "pending");
			
			RequestDispatcher reqD =  request.getRequestDispatcher("/reimbursement.html");
			reqD.include(request, response);
			
//			ticket.setTicketOwnerId(empId);
//			ticket.setTicketType(ticketType);
//			ticket.setAmount(amount);
//			ticket.setDescription(description);
//			ticket.setStatus("pending");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
