package org.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet1 extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		 Cookie ck[]=req.getCookies();  
		 out.print("Hello "+ck[0].getValue()+"<br/>");  
		 out.print("your age is  "+ck[1].getValue()+" is correct ?");  
		
	}

}
