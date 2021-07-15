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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "candidate111")
public class Candidate {
	@Id
	@Column(name = "candidate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "candidate_name")
	private String name;
	@Column(name = "candidate_mob")
	private String mob;
	@Column(name = "candidate_add")
	private String add;
	//@OneToMany(cascade = CascadeType.ALL)//mappedBy = "candidate")
	//private List<Course> courselist;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "course_id")
	//private Course course;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Course> courselist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	//public Course getCourse() {
	//	return course;
	//}
	//public void setCourse(Course course) {
	//	this.course = course;
	//}
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	
	
	}
}
