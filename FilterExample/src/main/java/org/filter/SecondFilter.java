package org.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SecondFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String password=req.getParameter("pword");
		
		if(password.equals("tech123")) {
			chain.doFilter(req,res);
		}
		else {
			req.getRequestDispatcher("LoginPage.html").include(req, res);
		}
	}
}
