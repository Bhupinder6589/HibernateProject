package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student121")
public class Student {
	@Id
	@Column(name = "s_id")
	//@GeneratedValue(generator = "mygene")
	//@GenericGenerator(name = "mygene",strategy = "custom_id_generator.CustomGenerator")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "mygene")
	@SequenceGenerator(name = "mygene" ,sequenceName = "autoincrement",allocationSize = 2)
	//@GeneratedValue(strategy = GenerationType.TABLE,generator = "mygene")
	//@TableGenerator(name = "mygene",table = "id_tab",pkColumnName = "stud_id",pkColumnValue = "student_id",
	//valueColumnName = "hi_value",schema = "public",allocationSize = 1)
	private int id;
	@Column(name = "s_name")
	private String name;
	@Column(name = "s_email")
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
