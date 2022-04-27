package org.loginvalidation;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomePage extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String n=(String) req.getAttribute("name");
		PrintWriter out=res.getWriter();
		out.println("<h1>Welcome to the worlds number one e-shop center "+n+"<h1>");
	}
}
