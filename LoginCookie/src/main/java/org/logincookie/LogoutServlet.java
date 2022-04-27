package org.logincookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet  extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
	    PrintWriter out = res.getWriter();  
	    
	    req.getRequestDispatcher("Common.html").include(req, res);  
	    
	    Cookie c = new Cookie("name", "");
        c.setMaxAge(0);
        res.addCookie(c);
        
        out.println("your are sucessfully loged out");
        
        RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
		rd.include(req, res);
	}

}
