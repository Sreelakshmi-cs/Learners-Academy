package Entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	private int  class_id;
	
	@Column(name="cname")
	private  String class_name;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cls")
	private List<Student> student;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="classes_subjectlink",joinColumns= {@JoinColumn(name="cid")},inverseJoinColumns= {@JoinColumn(name="sid")})
	private List<Subject> subject;
	

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}



	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	} 
	
	@Override
	public String toString() {
		return "Classes [class_name=" + class_name + "]";
	}


}

