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

import Entities.Student;
import Entities.Subject;
import Entities.Teacher;
import Util.HibernateUtil;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/addteacherServlet")

public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddTeacher.jsp").include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("tname");
		    int age  = Integer.valueOf(request.getParameter("tage"));
			String gender = request.getParameter("gender");
			int sid= Integer.valueOf(request.getParameter("subid"));
			
			Teacher teacher=new Teacher();
			teacher.setTeach_name(name);
			teacher.setTeach_age(age);
			teacher.setTeach_gen(gender);
			
			Subject subject=new Subject();
			subject.setSub_id(sid);
			teacher.setSubject(subject);
			
			
			//create sessionFactory object
			org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
			
			//create session object 
			Session session = sf.openSession();
			
			//begin Transaction
			Transaction tx = session.beginTransaction();
			
			session.save(teacher);
			
			tx.commit();
			
			PrintWriter out = response.getWriter();
			out.append("Teacher saved successfully!!!");
			RequestDispatcher re=request.getRequestDispatcher("/Home.jsp");
			re.include(request,response);
			
			}
			
			catch(Exception e)
			{
				PrintWriter out = response.getWriter();
				out.append("Please Check and enter the values exceptions occured!!!");
				out.println(e.getMessage());
				RequestDispatcher re=request.getRequestDispatcher("/AddTeacher.jsp");
				re.include(request,response);
			}
	}

}
