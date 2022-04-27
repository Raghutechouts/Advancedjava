package org.loginvalidation;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginChecker extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
	    PrintWriter out = res.getWriter();  
		String name=req.getParameter("uname");
		String password1=req.getParameter("pword");
		req.setAttribute("name",name);
		if(password1.equals("Techouts@12345")) {
			RequestDispatcher rd=req.getRequestDispatcher("WelcomePage1");
			rd.forward(req, res);
		}
		else {
			out.println("<h3>Sorry check your password</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/LoginPage.html");
			rd.include(req, res);
		}
	}
}
