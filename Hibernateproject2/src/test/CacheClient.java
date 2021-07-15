package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class CacheClient {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate.cfg.xml");
		SessionFactory sf =cfg.buildSessionFactory();
		
	//################ session level cache support ############################
	//	Session s1 = sf.openSession();	
	//	Employee e1 = (Employee)s1.get(Employee.class, 1);
	//	Employee e2	= (Employee)s1.get(Employee.class, 1);
	
	//	System.out.println(e1.getName());
	//	System.out.println(e1.getEmail());
	//	System.out.println(e2.getName());
	//	System.out.println(e2.getEmail());
	//	System.out.println("##############################################");
	//	Session s2 = sf.openSession();
	//	Employee es2 = (Employee)s2.get(Employee.class, 1);
	
	//	System.out.println(es2.getName());
	//	System.out.println(es2.getEmail());
	
		//################ Query level cache support ############################
	//	Session session = sf.openSession();	
	//	Query q = session.createQuery("from Employee");
	//	q.setCacheable(true);
	//	List<Employee> list = q.list();
	//	for (Employee employee : list) {
	//		System.out.println(employee.getName());
	//		System.out.println(employee.getEmail());
	//	}
	
	//	Query q1 = session.createQuery("from Employee");
	//	q1.setCacheable(true);
	//	List<Employee> list1 = q1.list();
	//	for (Employee employee : list1) {
	//		System.out.println(employee.getName());
	//		System.out.println(employee.getEmail());
	//	}
	
	//	Query q2 = session.createQuery("from Employee");
	//	//q2.setCacheable(true);
	//	List<Employee> list2 = q2.list();
	//	for (Employee employee : list2) {
	//		System.out.println(employee.getName());
	//		System.out.println(employee.getEmail());
	//	}
	
		//################ Second level cache support ############################
		
			Session s1 = sf.openSession();	
			Employee e1 = (Employee)s1.get(Employee.class, 1);
			Employee e2	= (Employee)s1.get(Employee.class, 1);
			
			System.out.println(e1.getName());
			System.out.println(e1.getEmail());
			System.out.println(e2.getName());
			System.out.println(e2.getEmail());
			System.out.println("##############################################");
			Session s2 = sf.openSession();
			Employee es2 = (Employee)s2.get(Employee.class, 1);
			
			System.out.println(es2.getName());
			System.out.println(es2.getEmail());
			
	}

}
