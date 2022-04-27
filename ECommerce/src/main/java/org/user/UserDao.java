package org.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","techouts");
	}
	public static int save(User u) {
		int status=0;
		 try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into userdata(name,email,username,password) values(?,?,?,?);");
			ps.setString(1,u.getName() );
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			status=ps.executeUpdate();
			con.close();
		}
		 catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public static boolean checker(User u) {
			try {
				Connection con = getConnection();
				PreparedStatement ps=con.prepareStatement("select * from userdata;");
				ResultSet rs=ps.executeQuery();
				String username=u.getUsername();
				String password=u.getPassword();
				
				while(rs.next()) {
					String bdUsername=rs.getString(3);
					String dbPassword=rs.getString(4);
				
					if((username.equals(bdUsername) )&&(password.equals(dbPassword))) {
						return true;
					}
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
	}
}
