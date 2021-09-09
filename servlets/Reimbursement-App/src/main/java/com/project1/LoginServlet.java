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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		try {
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			boolean flag = dao.verifyUser(email, password);
			if(flag == true) {
				Employee employee = new Employee();
				employee.setName(dao.getEmployeeName(email));
				employee.setEmail(email);
				employee.setPassword(password);

				Cookie cookieE = new Cookie("email", employee.getEmail());
				Cookie cookieP = new Cookie("password", employee.getPassword());
				Cookie cookieN = new Cookie("name", employee.getName());
				response.addCookie(cookieE);
				response.addCookie(cookieP);
				response.addCookie(cookieN);

//				RequestDispatcher reqD =  request.getRequestDispatcher("/reimbursement.html");
//				reqD.include(request, response);
				RequestDispatcher reqD =  request.getRequestDispatcher("/data.php");
				reqD.include(request, response);

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