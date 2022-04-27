package org.firstapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String userName=req.getParameter("uname");
		String passWord=req.getParameter("pword");
		PrintWriter writer = res.getWriter();
		String htmlRespone = "<html>";
        htmlRespone += "<h3>Your username is: " + userName + "<br/>";      
        htmlRespone += "Your password is: " + passWord + "</h3>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);

	}
}
