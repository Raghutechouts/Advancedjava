package org.loginout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDao {
	
	public static boolean validateData(String uname,String pass){
		boolean status=false;
		try {
			String url="jdbc:mysql://localhost:3306/techouts";
			String dbuname="root";
			String dbpass="techouts";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,dbuname,dbpass);
		PreparedStatement ps=con.prepareStatement("select * from employee where username=? and password=?;");
		ps.setString(1,uname);  
		ps.setString(2,pass);  
		ResultSet rs=ps.executeQuery();  
	    status=rs.next();
	    con.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}


}
