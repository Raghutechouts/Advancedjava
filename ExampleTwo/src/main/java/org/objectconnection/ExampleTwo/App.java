package org.objectconnection.ExampleTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ){
    	
    	StudentAddress sa  = new StudentAddress();
    	sa.setCity("hyd");
    	sa.setCountry("india");
    	sa.setState("telangana");
    	
    	Student st = new Student();
    	st.setRollNo(100);
    	st.setName("virat");
    	st.setAddress(sa);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tr = session.beginTransaction();
    	session.save(st);
    	tr.commit();
    	session.close();
    	
    }
}
