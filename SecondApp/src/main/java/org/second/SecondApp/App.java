package org.second.SecondApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("virat");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf= con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts=session.beginTransaction();

		session.save(emp);
		ts.commit();
		sf.close();
		session.close();
		

	}
}
