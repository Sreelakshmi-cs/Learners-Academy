package Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int  student_id;
	
	@Column(name="name")
	private String student_name;
	
	@Column(name="age")
	private int student_age;
	
	@Column(name="gender")
	private String student_gender;
	
	@Column(name="hometown")
	private String town;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="clas_id")
	private Classes cls;


	public int getStudent_id()
	{
		return student_id;
	}


	public void setStudent_id(int student_id)
	{
		this.student_id = student_id;
	}


	public String getStudent_name() 
	{
		return student_name;
	}


	public void setStudent_name(String student_name)
	{
		this.student_name = student_name;
	}


	public int getStudent_age()
	{
		return student_age;
	}


	public void setStudent_age(int student_age)
	{
		this.student_age = student_age;
	}



	public String getStudent_gender()
	{
		return student_gender;
	}


	public void setStudent_gender(String student_gender)
	{
		this.student_gender = student_gender;
	}


	public String getTown()
	{
		return town;
	}


	public void setTown(String town)
	{
		this.town = town;
	}


	public Classes getCls() {
		return cls;
	}


	public void setCls(Classes cls) {
		this.cls = cls;
	}	
	
}
