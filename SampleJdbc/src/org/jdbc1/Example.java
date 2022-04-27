package org.jdbc1;



import java.sql.*;


public class Example {

	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/techouts";
		String uname="root";
		String pass="techouts";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
//		st.executeUpdate("insert into employees values(101,'virat',20000)");
		st.executeUpdate("create table sample(id int,name varchar(20),sal int)");
//		ResultSet rs=st.executeQuery("select * from student");
//		while(rs.next()) {
//			System.out.println("id is: "+rs.getInt(1)+" and name is: "+rs.getString(2));
//		}
//		
		st.close();
		con.close();
	}

}
