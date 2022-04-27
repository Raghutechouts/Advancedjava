package org.addtocart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.product.ProductDao;
import org.product.ProductDetails;

public class CartDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","techouts");
	}
	public static int saveAddToCart(String productName,String userName) {
		int status=0;
		try {
			//ProductDetails p = new ProductDetails();
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?,?,?);");
			List <ProductDetails> list =  ProductDao.getProductDataPdp(productName);
			ps.setString(1, userName);
			for(ProductDetails p:list) {
				ps.setString(2,p.getProductName() );
				ps.setString(3, p.getProductDesc());
				ps.setInt(4, p.getPrice());
				ps.setString(5, p.getUrl());
				ps.setString(6, p.getProductCtg());

			}
			status=ps.executeUpdate();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;

	}

	public static List<ProductDetails> getCartData(String username) {
		List<ProductDetails> ls =new ArrayList<>(); 
		try { 
			Connection con =	getConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from cart where userName=?;");
			ps.setString(1, username); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductDetails p=new ProductDetails();
				p.setProductName(rs.getString(2));
				p.setProductDesc(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setUrl(rs.getString(5));
				p.setProductCtg(rs.getString(6));
				ls.add(p);
			}
			con.close();

		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		return ls;

	}
	public static int saveToOrders(String productName,String userName) {
		int status=0;
		try {
			//ProductDetails p = new ProductDetails();
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orders values(?,?,?,?,?,?);");
			List <ProductDetails> list =  ProductDao.getProductDataPdp(productName);
			ps.setString(1, userName);
			for(ProductDetails p:list) {
				ps.setString(2,p.getProductName() );
				ps.setString(3, p.getProductDesc());
				ps.setInt(4, p.getPrice());
				ps.setString(5, p.getUrl());
				ps.setString(6, p.getProductCtg());

			}
			status=ps.executeUpdate();
			CartDao.deleteFromCart(productName, userName);
			con.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;

	}
	public static int deleteFromCart(String productName,String userName) {
		int status=0;
		try {
			//ProductDetails p = new ProductDetails();
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from cart where userName=? and  productName=?; ");
			ps.setString(1, userName);
			ps.setString(2,productName);
			status=ps.executeUpdate();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;

	}
	public static List<ProductDetails> getOrderData(String username) {
		List<ProductDetails> ls =new ArrayList<>(); 
		try { 
			Connection con =	getConnection(); 
			PreparedStatement ps=con.prepareStatement("select * from orders where userName=?;");
			ps.setString(1, username); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductDetails p=new ProductDetails();
				p.setProductName(rs.getString(2));
				p.setProductDesc(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setUrl(rs.getString(5));
				p.setProductCtg(rs.getString(6));
				ls.add(p);
			}
			con.close();

		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		return ls;

	}
	public static int deleteFromOrders(String productName,String userName) {
		int status=0;
		try {
			//ProductDetails p = new ProductDetails();
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from orders where userName=? and  productName=?; ");
			ps.setString(1, userName);
			ps.setString(2,productName);
			status=ps.executeUpdate();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return status;

	}

}
