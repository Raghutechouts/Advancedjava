package org.manytomany.ManyToManyExample;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) {
    	Configuration con = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Group.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Group group1 = new Group("MARVEL");
		Group group2 = new Group("DC");
		
		User user1 = new User("Virat", "2023-ManOfTheTournment","virat@gmail.com");
		User user2 = new User("Rohit", "2023-Wcup-winning-Cap","rohit@gmail.com");
		
		group1.addUser(user1);
		group1.addUser(user2);
		
		group2.addUser(user1);
		
		user1.addGroup(group1);	
		user1.addGroup(group2);
		user2.addGroup(group1);
		
		
		session.save(group1);
		session.save(group2);
		
		tr.commit();
		session.close();
		sf.close();
		
		
    }
}
