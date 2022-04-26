package org.onetomany.OneToManyExample;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args ) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(ProductDetails.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Category cat = new Category("HomeAppliences");

		ProductDetails mixer  = new ProductDetails("ButterFly", "2000 rpm very powerfull", 5500, cat);
		ProductDetails wash  = new ProductDetails("Heir", "Heavy load", 4000, cat);
		ProductDetails fridge  = new ProductDetails("Boach", "High-tech", 10000, cat);

		List<ProductDetails> product = new ArrayList<ProductDetails>();
		product.add(mixer);
		product.add(wash);
		product.add(fridge);

		cat.setProductDetails(product);

		session.save(cat);

		tr.commit();
		session.close();


	}
}
