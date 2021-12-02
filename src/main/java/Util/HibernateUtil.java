package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Classes;
import Entities.Student;
import Entities.Subject;
import Entities.Teacher;

public class HibernateUtil {
	
	public static SessionFactory buildSessionFactory()
	{
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}
