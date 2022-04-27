package org.loginout;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  

		String name=req.getParameter("uname");
		String pass=req.getParameter("pword");
		HttpSession hs=req.getSession();
		hs.setAttribute("name",name);

		if(EmployeeDao.validateData(name,pass)) {
			RequestDispatcher rd=req.getRequestDispatcher("welcome");
			rd.forward(req, res);
		}
		else {
			out.println("<h3>Sorry check your password</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/Login.html");
			rd.include(req, res);
		}

	}
}
