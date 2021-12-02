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

import Entities.Classes;
import Entities.Student;
import Util.HibernateUtil;

/**
 * Servlet implementation class ReadClassServlet
 */

@WebServlet("/readclassServlet")

public class ReadClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ReadClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		
		Session session=sf.openSession();
		
		List <Classes> clas=session.createQuery("from Classes").list();
		
		PrintWriter out=response.getWriter();
		if(clas!=null)
		{
			out.print("<h1><u>  ~~~ Learner's Academy ~~~ </u></h1>");

			out.print("<h2> Classess List</h2>");
			out.print("<style> table,td,th { border:2px solid red; padding:10px;}</style>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Class Id </th>");
			out.print("<th> Class Name </th>");
			out.print("</tr>");
			
			
			for(Classes c : clas) {
				out.print("<tr>");
				out.print("<td>"+c.getClass_id()+"</td>");
				out.print("<td>"+c.getClass_name() +"</td>");
				out.print("</tr>");
				out.print("<br/>");
		}
			
			out.print("</table>");
			out.print("<br/><a href='AddClass.jsp'>Add New Class</a>");
			out.print("<br/>");
			out.print("<br/><a href='Home.jsp'>Back Home</a>");
			out.print("<br/>");
			out.print("<br/><a href='Subject-Class.jsp'>Assign Subject</a>");
			
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
