package com.project1;

import java.io.IOException;
import java.io.PrintWriter;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet {
    public static final Employee LoginEmployee = null;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();


        String email = request.getParameter("email");
        String password = request.getParameter("password");



        if(EmployeeDAOFactory.dao.verifyUser(email, password)) {
            out.println("You are successfully logged in!");
            out.println("<br>Welcome "+ LoginEmployee.getName());

            Cookie cookieE = new Cookie("email", LoginEmployee.getEmail());
            Cookie cookieP = new Cookie("password", LoginEmployee.getPassword());
            Cookie cookieN = new Cookie("name", LoginEmployee.getName());
            response.addCookie(cookieE);
            response.addCookie(cookieP);
            response.addCookie(cookieN);

        } else {
            RequestDispatcher rd =  request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        }
        out.close();
    }
}
