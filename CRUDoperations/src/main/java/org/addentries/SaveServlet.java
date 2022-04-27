package org.addentries;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adding")
public class SaveServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  

		int id=Integer.parseInt(req.getParameter("id"));
		String mail=req.getParameter("mail");
		String passord=req.getParameter("pword");
		int salary=Integer.parseInt(req.getParameter("salary"));
		Employee e=new Employee();
		e.setId(id);
		e.setEmail(mail);
		e.setPassword(passord);
		e.setSalary(salary);
		
		if(EmployeeDao.save(e)>0) {
			out.println("<h2>Data added sucessfully</h2>");
			req.getRequestDispatcher("/AddEntries.html").include(req, res);
		}
		else {
			out.println("<h2>Please add perfect entries</h2>");
			req.getRequestDispatcher("/AddEntries.html").include(req, res);

		}
	}

}
