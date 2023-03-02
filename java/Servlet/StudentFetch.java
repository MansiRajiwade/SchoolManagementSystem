package Servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Student;


@WebServlet("/fetchStudent")
public class StudentFetch extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
		EntityManager em=emf.createEntityManager();
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		
	
		Student s=em.find(Student.class, id1);
		
		
		HttpSession hs=req.getSession();
		hs.setAttribute("studentlist", s);
		RequestDispatcher rd=req.getRequestDispatcher("ViewStudent.jsp");
		rd.forward(req, resp);
		

	}
}