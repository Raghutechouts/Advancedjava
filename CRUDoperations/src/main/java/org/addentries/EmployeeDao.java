package org.addentries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/techouts";
		String dbuname="root";
		String dbpass="techouts";
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,dbuname,dbpass);
	}
	public static int save(Employee e){
		int status=0;
		try {
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into sample(id,email,password,salary) values(?,?,?,?);");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			ps.setInt(4, e.getSalary());
			status=ps.executeUpdate();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return status;
	}
	public static List<Employee> show() {
		List<Employee> ls=new ArrayList<>();
		try {
			Connection con  = EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from sample;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setSalary(rs.getInt(4));
				ls.add(e);
			}
			con.close();
		} 

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	public static int update(Employee e){
		int status=0;
		try {
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE sample SET   email=? ,password=?,salary=? WHERE id=?");
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setInt(3, e.getSalary());
			ps.setInt(4, e.getId());
			status=ps.executeUpdate();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return status;
	}
	public static int delete(int id) {
		int status =0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from sample where id=?; ");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		return status;
		
	}
}
