package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.Classes;
import Entities.Student;
import Util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */

@WebServlet("/addstudentServlet")

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddStudent.jsp").include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String name = request.getParameter("sname");
	    int age  = Integer.valueOf(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String town =request.getParameter("town");
		int id=Integer.valueOf(request.getParameter("class_id"));
		
		
		
		Student student=new Student();
		student.setStudent_name(name);
		student.setStudent_age(age);
		student.setStudent_gender(gender);
		student.setTown(town);
		
		Classes cls=new Classes();
		cls.getStudent().add(student);
		
	
		//create sessionFactory object
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		//create session object 
		Session session = sf.openSession();
		
		//begin Transaction
		Transaction tx = session.beginTransaction();
		
		session.save(student);
		
		tx.commit();
		
		PrintWriter out = response.getWriter();
		out.append("Student saved successfully!!!");
		RequestDispatcher re=request.getRequestDispatcher("/Home.jsp");
		re.include(request,response);
		
		}
		
		catch(Exception e)
		{
			PrintWriter out = response.getWriter();
			out.append("Please Check and enter the values exceptions occured!!!");
			out.println(e.getMessage());
			RequestDispatcher re=request.getRequestDispatcher("/AddStudent.jsp");
			re.include(request,response);
		}
		
	}

}
