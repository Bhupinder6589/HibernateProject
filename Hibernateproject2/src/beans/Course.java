package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Course111")
public class Course {
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	@Column(name = "course_name")
	private String course_name;
	@Column(name = "course_fee")
	private String course_fee;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Candidate> candidateList;
	
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name = "candidate_id")
	//private Candidate candidate;
	
	
	//@OneToOne(cascade = CascadeType.ALL,mappedBy = "course")
	//@JoinColumn(name = "canditate_id")
	//private Candidate candidate;
	
	
	//public Candidate getCandidate() {
	//	return candidate;
	//}

	//public void setCandidate(Candidate candidate) {
	//	this.candidate = candidate;
	//}
	
	//public Candidate getCandidate() {
	//	return candidate;
	//}
	//public void setCandidate(Candidate candidate) {
	//	this.candidate = candidate;
	//}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_fee() {
		return course_fee;
	}
	public void setCourse_fee(String course_fee) {
		this.course_fee = course_fee;
	}
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
}
