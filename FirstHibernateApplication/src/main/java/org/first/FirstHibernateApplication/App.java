package org.first.FirstHibernateApplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{


		Configuration con =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);

		SessionFactory sf =  con.buildSessionFactory();

		Student st1 = new Student();


		st1.setId(104);
		st1.setName("rahul");
		st1.setCity("mumbai");

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st1);
		tx.commit();
		sf.close();
		session.close();

	}
}
