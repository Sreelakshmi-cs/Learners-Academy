package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name="Teacher")
public class Teacher
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tid")
	private int teach_id;
	
	@Column(name="tname")
	private String teach_name;
	
	@Column(name="tage")
	private int teach_age;
	
	@Column(name="tgen")
	private String teach_gen;
	
	@OneToOne
	private Subject subject;
	
	
	public int getTeach_id() {
		return teach_id;
	}

	public void setTeach_id(int teach_id) {
		this.teach_id = teach_id;
	}

	public String getTeach_name() {
		return teach_name;
	}

	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}

	public int getTeach_age() {
		return teach_age;
	}

	public void setTeach_age(int teach_age) {
		this.teach_age = teach_age;
	}

	public String getTeach_gen() {
		return teach_gen;
	}

	public void setTeach_gen(String teach_gen) {
		this.teach_gen = teach_gen;
	}


	public String getSubject() {
		StringBuffer sb= new StringBuffer();
		if(subject!=null)
		{
			sb.append(subject);
		}
		return subject.toString();
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	
	
}
	

