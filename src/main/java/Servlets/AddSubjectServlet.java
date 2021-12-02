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

import Entities.Subject;
import Entities.Teacher;
import Util.HibernateUtil;

/**
 * Servlet implementation class AddSubjectServlet
 */

@WebServlet("/AddSubjectServlet")

public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddSubject.jsp").include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String name = request.getParameter("sname");
			String code = request.getParameter("scode");
			
			Subject subject=new Subject();
			subject.setSub_name(name);
			subject.setSub_code(code);	
			
			//create sessionFactory object
			org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
			
			//create session object 
			Session session = sf.openSession();
			
			//begin Transaction
			Transaction tx = session.beginTransaction();
			
			session.save(subject);
			
			tx.commit();
			
			PrintWriter out = response.getWriter();
			out.append("Subject added successfully!!!");
			RequestDispatcher re=request.getRequestDispatcher("/Home.jsp");
			re.include(request,response);
			
			}
			
			catch(Exception e)
			{
				PrintWriter out = response.getWriter();
				out.append("Please Check and enter the values exceptions occured!!!");
				out.println(e.getMessage());
				RequestDispatcher re=request.getRequestDispatcher("/AddSubject.jsp");
				re.include(request,response);
			}
	}

}
