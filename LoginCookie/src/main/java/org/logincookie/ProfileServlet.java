package org.logincookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
	    PrintWriter out = res.getWriter();  
	    
	    req.getRequestDispatcher("Common.html").include(req, res);  
	    
	    Cookie c[]=req.getCookies();
	    if(c==null) {
	    	out.println("<h2> Please log in first</h2>");
	    	RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
			rd.include(req, res);
	    }
	    else {
	    	String name=c[0].getValue();
	    	out.println(" <h2>Hello "+name+" Welcome to  your profile<h2> <br/><br/>");
	    	out.println("<h3>Please update your profile<h3>");
	    }
	    
	    
	}

}
