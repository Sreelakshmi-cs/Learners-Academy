package Servlets;

import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entities.Student;
import Util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/readstudentServlet")

public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		
		Session session=sf.openSession();
		
		//Reading the Student Table
		List <Student> students=session.createQuery("from Student").list();
		try
		{
		PrintWriter out=response.getWriter();
		if(students!=null) {
		out.print("<h1><u>  ~~~ Learner's Academy ~~~ </u></h1>");
		out.print("<h2> Students List</h2>");
		out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Student Id </th>");
		out.print("<th> Student Name </th>");
		out.print("<th> Student Age</th>");
		out.print("<th> Student Gender</th>");
		out.print("<th> Student HomeTown</th>");
		out.print("<th> Assigned Class</th>");
		out.print("</tr>");
		
		for(Student student : students) {
			out.print("<tr>");
			out.print("<td>"+student.getStudent_id()+"</td>");
			out.print("<td>"+student.getStudent_name() +"</td>");
			out.print("<td>"+student.getStudent_age()+"</td>");
			out.print("<td>"+student.getStudent_gender()+"</td>");
			out.print("<td>"+student.getTown()+"</td>");
			out.print("<td>"+student.getCls()+"</td>");
			out.print("</tr>");
			out.print("<br/>");
			
		}
				
		out.print("</table>");
		out.print("<br/><a href='AddStudent.jsp'>Add New Student</a>");
		out.print("<br/>");
		out.print("<br/><a href='Home.jsp'>Back Home</a>");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
