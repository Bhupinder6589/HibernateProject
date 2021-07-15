package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Candidate;
import beans.Course;

public class GetDetails {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("config/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
//		Candidate c = (Candidate)session.get(Candidate.class, 1);
//		System.out.println(c.getId());
//		System.out.println(c.getName());
//		System.out.println(c.getMob());
//		System.out.println(c.getAdd());
//		//System.out.println(c.getCourselist());
//		System.out.println(c.getCourselist().get(0).getCourse_name());
//		System.out.println(c.getCourselist().get(1).getCourse_name());
//		System.out.println(c.getCourselist().get(2).getCourse_name());
//		
//		
//		System.out.println("\n#########################################\n");
		
		Course co= (Course)session.get(Course.class, 1);
		System.out.println(co.getCourse_id());
		System.out.println(co.getCourse_name());
		System.out.println(co.getCourse_fee());
		System.out.println(co.getCandidateList().get(0).getName());
		System.out.println(co.getCandidateList().get(1).getName());
		System.out.println(co.getCandidateList().get(2).getName());
		
		session.close();
		sf.close();
	}

}
