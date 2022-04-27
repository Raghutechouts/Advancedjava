package org.addentries;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showdata")
public class ShowServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter(); 
		List<Employee> ls=EmployeeDao.show();
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Email</th><th>Password</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
		for(Employee c:ls){
		out.print("<tr><td>"+c.getId()+"</td><td>"+c.getEmail()+"</td><td>"+c.getPassword()+"</td>"
		+" <td>"+c.getSalary()+"</td><td><a href='update.html?id="+c.getId()+"'>edit</a></td>"
		+" <td><a href='delete?id="+c.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print(" <a href='AddEntries.html'> click here to goto Add Employee Details</a>");
		out.close();
	}

}
