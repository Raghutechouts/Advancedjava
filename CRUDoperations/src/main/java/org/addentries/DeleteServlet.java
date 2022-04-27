package org.addentries;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  
		int id=Integer.parseInt(req.getParameter("id"));
		if(EmployeeDao.delete(id)>0) {
			out.println("<h2> Employee details deleted sucessfully</h2>");
			req.getRequestDispatcher("showdata").include(req, res);
		}
	}
}
