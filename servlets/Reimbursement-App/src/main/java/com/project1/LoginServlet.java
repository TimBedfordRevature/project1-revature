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

public class LoginServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>HELLO</h1>");

	
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		


		try {
			out.print("<h1>TEST</h1>");
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			out.print("<h1>TEST 2</h1>");
			boolean flag = dao.verifyUser(email, password);
			out.print("<h1>TEST 3</h1>");
			if(flag == true) {
				Employee employee = new Employee();
				employee.setName(dao.getEmployeeName(email));
				employee.setEmail(email);
				employee.setPassword(password);
				out.println("<h1>You are successfully logged in!</h1>");
				out.println("<br>Welcome "+ employee.getName());

				Cookie cookieE = new Cookie("email", employee.getEmail());
				Cookie cookieP = new Cookie("password", employee.getPassword());
				Cookie cookieN = new Cookie("name", employee.getName());
				response.addCookie(cookieE);
				response.addCookie(cookieP);
				response.addCookie(cookieN);

//				RequestDispatcher rd = request.getRequestDispatcher("/reimbursement.html");

			} else {
				out.print("<script>\r\n"
						+ "    alert(\"ERROR: Incorrect credentials\")\r\n"
						+ "</script>");
				RequestDispatcher rd =  request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		out.close();
	}
}