package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;

import beans.Student;


public class ClientAnnotations 
{
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx	= session.beginTransaction();
		
	//##################### Select All Operation ############################
	//	Query q = session.createQuery("from Student");
	//	List<Student> studentlist = q.list();
	//	for (Student student : studentlist) {
	//		System.out.println(student.getId());
	//		System.out.println(student.getName());
	//		System.out.println(student.getEmail());
	//	}
		
	//##################### Select Operation on a particular column ############################	
	//	Query q = session.createQuery("select name from Student");
	//	List<String> namelist= q.list();
	//	for (String name : namelist) {
	//		System.out.println(name);
	//}
		
	//##################### Select Operation based on condition ############################	
	//	Query q = session.createQuery("from Student where id=:ID");
	//	q.setInteger("ID", 1);
	//	Student s = (Student) q.uniqueResult();
	//	System.out.println(s.getId());
	//	System.out.println(s.getName());
	//	System.out.println(s.getEmail());
		
	//##################### Update Operation based on condition ############################
		
		//Query q = session.createQuery("update Student set name =:Name,email =:Email where id =:ID");	
		//q.setString("Name", "gagan");
		//q.setString("Email", "gaganshanker@gmail.com");
		//q.setInteger("ID", 1);
		//q.executeUpdate();
		//tx.commit();
	//##################### Delete Operation based on condition ############################
		//Query q = session.createQuery("delete Student where id = :ID");
		//q.setInteger("ID", 1);
		//int i = q.executeUpdate();
		//tx.commit();
		//System.out.println(i);
	//##################### Insert Operation ############################
	
	//HQL INSERT statement can only use data provided by an HQL SELECT statement
		
		
		//Query query=session.createQuery("insert into purged_accounts(id, code, status) "+
		//	    "select id, code, status from account where accStatus=:status");
		//query.setString("accStatus", "PURGED");
		//int rowsCopied=query.executeUpdate();
		//tx.commit();
	
	//##################### Select operation based on criteria ###############
		
		//Criteria cr = session.createCriteria(Student.class);
		//List<Student> studentlist= cr.list();
		//	for (Student student : studentlist) {
		//		System.out.println(student.getId());
		//		System.out.println(student.getName());
		//		System.out.println(student.getEmail());
		//	}
	
	//##################### Select operation based on criteria having restrictions ###############
		
	//	Criteria cr = session.createCriteria(Student.class); //select * from Student
	//	Criterion c1 = Restrictions.eq("id", 2);	            //where id = 2
	//	Criterion c2 = Restrictions.gt("id",2);
	//	LogicalExpression log = Restrictions.or(c1, c2);
	//	cr.add(log);
	//	//cr.add(c1); // in case of multiple adding of restriction then by default AND condition is applied
	//	//cr.add(c2);
		
	//	List<Student> l = cr.list();
	//	for (Student s : l) {
	//		System.out.println(s.getId());
	//		System.out.println(s.getEmail());
	//		System.out.println(s.getName());
			
	//	}
		
		//Student s = (Student)cr.uniqueResult();
		//System.out.println(s.getId());
		//System.out.println(s.getEmail());
		//System.out.println(s.getName());
		
	//##################### Select operation based on criteria having projections ###############	
		
		Criteria cr	= session.createCriteria(Student.class);
		Projection p1 = Projections.property("name");
		Projection p2 = Projections.property("email");
		ProjectionList plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		cr.setProjection(plist);
		List<Object[]> l = cr.list();
		System.out.println(l);
		for (Object[] o : l) {
			System.out.println("Name = "+o[0]);
			System.out.println("Email = "+o[1]);
		}
		
		
	}
}
