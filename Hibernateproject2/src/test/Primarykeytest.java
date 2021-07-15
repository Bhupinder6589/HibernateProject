package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Primarykeytest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		

		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		
		student1.setName("kalu");
		student1.setEmail("kalu@gmail.com");
		
		student2.setName("lalu");
		
		student2.setEmail("lalu@gmail.com");
		
		student3.setName("aalu");
		student3.setEmail("aalu@gmail.com");
		
		//drop SEQUENCE autoincrement

		//create sequence autoincrement
		//start with 1000
		//increment by 1
		//no cycle 
		
		
		
		int pk1 = (int)session.save(student1);   // select 1012 ---> 1012*1=1012
		int pk2 = (int)session.save(student2);	//  update 1013
		int pk3 = (int)session.save(student3);	//  select 1013 ----> 1013*1=1013
												//  update 1014
		tx.commit();							//  select 1014 ----->1014*1=1014
		System.out.println(pk1);				//  update 1015
		System.out.println(pk2);
		System.out.println(pk3);
		
		session.close();
		sf.close();
	}

}
