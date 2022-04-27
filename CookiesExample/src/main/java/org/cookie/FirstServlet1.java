package org.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet1 extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name"); 
		String age=req.getParameter("age");
		Cookie c=new Cookie("name",name);
		res.addCookie(c);
		Cookie c1=new Cookie("age",age);
		res.addCookie(c1);
		
		out.println("Name is "+name+"<br/>");
		out.println("His Age is "+age+"<br/>");
		out.println("<a href='second'><b>Click Here</b></a>");
		
		
	}

}
