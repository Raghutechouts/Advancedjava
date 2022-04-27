package org.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ProductDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","techouts");
	}
	public static int save(ProductDetails p) {
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into productdetails values(?,?,?,?,?);");
			ps.setString(1,p.getProductName() );
			ps.setString(2, p.getProductDesc());
			ps.setInt(3, p.getPrice());
			ps.setString(4, p.getUrl());
			ps.setString(5, p.getProductCtg());
			status=ps.executeUpdate();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;

	}
	public static List<ProductDetails> getProductData(String id) {
		List<ProductDetails> ls =new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps=con.prepareStatement("select * from productdetails where ProductCtg=?;");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductDetails p=new ProductDetails();
				p.setProductName(rs.getString(1));
				p.setProductDesc(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setUrl(rs.getString(4));
				p.setProductCtg(rs.getString(5));
				ls.add(p);
			}
			con.close();

		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return ls;
	}
	public static List<ProductDetails> getProductDataPdp(String name) {
		List<ProductDetails> ls =new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps=con.prepareStatement("select * from productdetails where ProductName=?;");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductDetails p=new ProductDetails();
				p.setProductName(rs.getString(1));
				p.setProductDesc(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setUrl(rs.getString(4));
				p.setProductCtg(rs.getString(5));
				ls.add(p);
			}
			con.close();

		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return ls;
	}

}
