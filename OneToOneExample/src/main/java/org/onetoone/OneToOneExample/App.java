package org.onetoone.OneToOneExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args ) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(ProductDetails.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Product prdut = new Product();
		prdut.setProductName("Samsung");
		prdut.setPrice(10000);

		ProductDetails pDetails = new ProductDetails();
		pDetails.setProductDescription("ABCDEFGHIJ");
		pDetails.setDimenctions("12.5cm - 6cm");
		pDetails.setWeight(100);

		prdut.setProductDetails(pDetails);
		pDetails.setProduct(prdut); 
		
		session.save(prdut);
		tr.commit();
		session.close();
		sf.close();
	}
}
