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

import Entities.Subject;
import Util.HibernateUtil;

/**
 * Servlet implementation class ReadSubjectServlet
 */
@WebServlet("/readsubjectServlet")

public class ReadSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ReadSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		
		Session session=sf.openSession();
		
		//Reading the Subject Table
		List <Subject> subjects=session.createQuery("from Subject").list();
		try
		{
		PrintWriter out=response.getWriter();
		if(subjects!=null)
		{
		out.print("<h1><u>  ~~~ Learner's Academy ~~~ </u></h1>");
		out.print("<h2> Subjects List</h2>");
		out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Subject Id </th>");
		out.print("<th> Subject Name </th>");
		out.print("<th> Subject Code</th>");
		out.print("</tr>");
		
		for(Subject sc:subjects) {
			out.print("<tr>");
			out.print("<td>"+sc.getSub_id()+"</td>");
			out.print("<td>"+sc.getSub_name() +"</td>");
			out.print("<td>"+sc.getSub_code()+"</td>");
			out.print("</tr>");
			out.print("<br/>");
			
		}
		out.print("</table>");
		out.print("<br/><a href='AddSubject.jsp'>Add New Subject</a>");

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
