package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Student;
import Entity.Teacher;
@WebServlet("/deleteStudent")
public class StudentDelete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			String id=req.getParameter("id");
			int id1=Integer.parseInt(id);
			
			Student s=em.find(Student.class, id1);
			
			et.begin();
			em.remove(s);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.print("Data Deleted Successfully!Thank you!");
			resp.setContentType("text/html");
			
			RequestDispatcher rd=req.getRequestDispatcher("StudentCRUD.html");
			rd.include(req, resp);
			
			
	}
	
}