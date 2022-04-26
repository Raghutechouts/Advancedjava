package org.registerpage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {

	public String saveRegisterDetails(User u) {
	String i="";
	Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tr = session.beginTransaction();
	
	i=((String) session.save(u)) ;
	tr.commit();
	session.close();
	return i;
	}

	public List<User> showRegisterDetails() {
	List<User> list = new ArrayList<User>();
	Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tr = session.beginTransaction();
	
	TypedQuery query=session.createQuery("from Question");    
    list=query.getResultList();   

	tr.commit();
	session.close();
	return list;
	}
	
}
