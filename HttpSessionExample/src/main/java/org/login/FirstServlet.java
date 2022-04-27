package org.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		
		HttpSession hs=req.getSession();  //creating HttpSession object
		hs.setAttribute("name", name);    //setting values -----> these values are replicate thru out the session with out regarding how many request generated 
		String id=hs.getId();
		out.println("name is"+name+"<br/>");
		out.println("id is--------------->  "+id);
		out.println("<br/> <a href=\"second\">next one</a>");
		
		
	}
}
