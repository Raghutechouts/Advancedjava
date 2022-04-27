package org.loginout;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  
	
		HttpSession hs=req.getSession();
		String name=(String) hs.getAttribute("name");
		
		out.println("<h1> Hello welcome to profile "+name+"<h1>");
		
		out.println("<a href=\"Login.html\">Logout<a/>");
	}
}
