package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Candidate;
import beans.Course;

public class RealtionshipClient {

	public static void main(String[] args) {
		//Candidate candidate = new Candidate();
		//Course course = new Course();
		
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Candidate candidate1 = new Candidate();
		candidate1.setName("Bhalu");
		candidate1.setMob("9893938374");
		candidate1.setAdd("delhi");
		
		
		Candidate candidate2 = new Candidate();
		candidate2.setName("kala");
		candidate2.setMob("9893938374");
		candidate2.setAdd("Noida");
		
		Candidate candidate3 = new Candidate();
		candidate3.setName("baka");
		candidate3.setMob("9893938374");
		candidate3.setAdd("gurgaon");
		
		Course course1 = new Course();
		course1.setCourse_name("English");
		course1.setCourse_fee("1000");
		
		Course course2 = new Course();
		course2.setCourse_name("Science");
		course2.setCourse_fee("2000");
		
		Course course3 = new Course();
		course3.setCourse_name("Maths");
		course3.setCourse_fee("3000");
		
		
		List<Course> courselist1 = new ArrayList<Course>();
		courselist1.add(course1);
		courselist1.add(course2);
		courselist1.add(course3);
		candidate1.setCourselist(courselist1);
		
		List<Course> courselist2 = new ArrayList<Course>();
		courselist2.add(course1);
		courselist2.add(course2);
		courselist2.add(course3);
		candidate2.setCourselist(courselist2);
		
		List<Course> courselist3 = new ArrayList<Course>();
		courselist3.add(course1);
		courselist3.add(course2);
		courselist3.add(course3);
		candidate3.setCourselist(courselist3);
		
		
		List<Candidate> candidatelist1 = new ArrayList<Candidate>();
		candidatelist1.add(candidate1);
		candidatelist1.add(candidate2);
		candidatelist1.add(candidate3);
		course1.setCandidateList(candidatelist1);
		
		List<Candidate> candidatelist2 = new ArrayList<Candidate>();
		candidatelist2.add(candidate1);
		candidatelist2.add(candidate2);
		candidatelist2.add(candidate3);
		course2.setCandidateList(candidatelist2);
		
		List<Candidate> candidatelist3 = new ArrayList<Candidate>();
		candidatelist3.add(candidate1);
		candidatelist3.add(candidate2);
		candidatelist3.add(candidate3);
		course3.setCandidateList(candidatelist3);
		
		
		session.save(candidate1);
		session.save(candidate2);
		session.save(candidate3);
		session.save(course1);
		session.save(course2);
		session.save(course3);
		
		
		
		tx.commit();
		
		
		
		
		
		session.close();
		sf.close();
		
		
	}

}
