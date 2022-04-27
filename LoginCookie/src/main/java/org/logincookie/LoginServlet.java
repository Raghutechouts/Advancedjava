package org.logincookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
	    PrintWriter out = res.getWriter();  
	    
		String name=req.getParameter("uname");
		String password=req.getParameter("pword");
		
		
		 req.getRequestDispatcher("Common.html").include(req, res);  
		
		 
		 
		if(password.equals("tech123")) {
			out.println("<h2> successfuly logged in....</h2> ");
			Cookie c=new Cookie("name", name);
			res.addCookie(c);
			Cookie c1=new Cookie("password", password);
			res.addCookie(c);
		}
		else {
			out.println("<h2>Sorry check your password</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
			rd.include(req, res);
		}
	}

}
