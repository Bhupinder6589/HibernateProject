package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
	Configuration cfg = new Configuration();
			cfg.configure("config/hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Student student = new Student();
			student.setId(888);
			student.setName("jaishanker");
			student.setEmail("jaishanker@gmail.com");
			
			//********************insert operation**********************
			//int pk = (int)session.save(student);
			//System.out.println(pk);
			//session.persist(student);
			//session.saveOrUpdate(student);
			//tx.commit();
			
			//*******************update operation***********************
			
			//session.get(Student.class, 888); //duplicate object exception
			//session.update(student);
			
			//session.get(Student.class, 888);	//duplicate ibject exception not occured
			//session.merge(student);
			//tx.commit();
			
			
			//*******************delete operation***********************
			//Student s1 = new Student();
			//s1.setId(333);
			//session.delete(s1);
			//tx.commit();
			//session.evict(s1);
			

			//*******************single record select operation***********************
			
			//Student st= (Student)session.get(Student.class, 444);  //if id not found it will return null and performig
			//System.out.println(st.getId());						// typecast operation on it will give Nullpointer
			//System.out.println(st.getName());						// Exception.
			//System.out.println(st.getEmail());
			
			
			Student st= (Student)session.load(Student.class, 444);			//if id not not found in records then  
			System.out.println(st.getId());									//ObjectNotFoundException occured.
			System.out.println(st.getName());// at this point query executed
			System.out.println(st.getEmail());
			
			
			
			session.close();
			sf.close();
			
	}

}
