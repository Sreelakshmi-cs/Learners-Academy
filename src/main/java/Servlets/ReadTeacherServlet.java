package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entities.Student;
import Entities.Teacher;
import Util.HibernateUtil;

/**
 * Servlet implementation class ReadTeacherServlet
 */
@WebServlet("/readteacherServlet")

public class ReadTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ReadTeacherServlet() {
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
		List <Teacher> teachers=session.createQuery("from Teacher").list();
		try {
		PrintWriter out=response.getWriter();
		if(teachers!=null) 
		{
			out.print("<h1><u>  ~~~ Learner's Academy ~~~ </u></h1>");
		out.print("<h2> Teachers List</h2>");
		out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Teacher Id </th>");
		out.print("<th> Teacher Name </th>");
		out.print("<th> Teacher Age</th>");
		out.print("<th> Teacher Gender</th>");
		
		out.print("</tr>");
		

		for(Teacher tr : teachers) {
			out.print("<tr>");
			out.print("<td>"+tr.getTeach_id()    +"</td>");
			out.print("<td>"+tr.getTeach_name()+"</td>");
			out.print("<td>"+tr.getTeach_age()+"</td>");
			out.print("<td>"+tr.getTeach_gen()+"</td>");
			
			out.print("<br/>");
			
		}
		out.print("</table>");
		out.print("<br/><a href='AddTeacher.jsp'>Add New Teacher</a>");

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
