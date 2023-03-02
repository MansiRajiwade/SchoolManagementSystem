package Servlet;

import java.io.IOException;
import java.util.ArrayList;

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
import javax.servlet.http.HttpSession;

import Entity.Teacher;

@WebServlet("/fetch")
public class TeacherFetch extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
		EntityManager em=emf.createEntityManager();
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		
	
		Teacher t=em.find(Teacher.class, id1);
		
		
		HttpSession hs=req.getSession();
		hs.setAttribute("teacherlist", t);
		RequestDispatcher rd=req.getRequestDispatcher("ViewTeacher.jsp");
		rd.forward(req, resp);
		

	}
}