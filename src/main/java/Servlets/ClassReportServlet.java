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

import Entities.Classes;
import Entities.Student;
import Entities.Subject;
import Entities.Teacher;
import Util.HibernateUtil;

/**
 * Servlet implementation class ClassReportServlet
 */
@WebServlet("/classreportServlet")

public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String classname=request.getParameter("class");
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		
		Session session=sf.openSession();
		List <Student> students=session.createQuery("from Student").list();
		List <Teacher> teachers=session.createQuery("from Teacher").list();
		List <Subject> subjects=session.createQuery("from Subject").list();

		try
		{
			PrintWriter out=response.getWriter();
			
			if((students!=null)&&(teachers!=null) &&(subjects!=null))
			{
				out.print("<h1><u>  ~~~ Learner's Academy ~~~ </u></h1>");
				out.print("<h2> Class Report</h2>");
				out.print("<style> table,td,th { border:1px solid green; padding:5px;}</style>");
				out.print("<table>");
				out.print("<tr>");
				out.print("<th> Student Id </th>");
				out.print("<th> Student Name </th>");
				out.print("</tr>");
				
				for(Student student : students) 
				{
					
					{
						out.print("<tr>");
						out.print("<td>"+student.getStudent_id()+"</td>");
						out.print("<td>"+student.getStudent_name() +"</td>");
						out.print("</tr>");
						out.print("<br/>");
						
					}
				}
			}
		}
		catch(Exception e)
		{
			PrintWriter out = response.getWriter();
			out.append("Please Check and enter the values exceptions occured!!!");
			out.println(e.getMessage());
		}
		
		try
		{
		PrintWriter out=response.getWriter();
		if(subjects!=null)
		{
		out.print("<style> table,td,th { border:1px solid green; padding:5px;}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Subject Id </th>");
		out.print("<th> Subject Name </th>");
		out.print("<th> Subject Code </th>");
		
		out.print("</tr>");
		
		for(Subject sc:subjects) {
			out.print("<tr>");
			out.print("<td>"+sc.getSub_id()+"</td>");
			out.print("<td>"+sc.getSub_name() +"</td>");
			out.print("<td>"+sc.getSub_code()+"</td>");
			out.print("</tr>");
			out.print("<br/>");
			
		}
		}
		}
	
		catch(Exception e)
		{

			PrintWriter out = response.getWriter();
			out.append("Please Check and enter the values exceptions occured!!!");
			out.println(e.getMessage());
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
