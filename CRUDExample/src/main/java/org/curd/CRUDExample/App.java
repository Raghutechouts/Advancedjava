package org.curd.CRUDExample;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	protected SessionFactory sessionFactory;
	protected void setting() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		sessionFactory=con.buildSessionFactory();
	}
	protected void exit() {
		sessionFactory.close();
	}
	protected void create() {
		Session session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setName("Rahul");
		e.setSalary(200001);
		session.save(e);
		session.beginTransaction().commit();
		session.close();
	}
	protected void read() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> list =query.list();
		for(Employee e:list) {
			System.out.println("Employee id "+e.getId());
			System.out.println("Employee name "+e.getName());
			System.out.println("Employee salary "+e.getSalary());
		}
		session.close();
	}
	protected void update() {
		Session session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setId(1);
		e.setName("Virat kohli");
		e.setSalary(1000001);
		session.update(e);
		session.beginTransaction().commit();
		session.close();
	}
	protected void delete() {
		Session session = sessionFactory.openSession();
		Employee e = new Employee();
		e.setId(1);
		session.delete(e);
		session.beginTransaction().commit();
		session.close();

	}

	public static void main( String[] args ){
		App emp = new App();
		emp.setting();
		emp.create();
		emp.read();
		emp.exit();



	}
}
