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

import Entity.Teacher;
@WebServlet("/teacheradd")
public class TeacherInsert extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	      String name=req.getParameter("name");
	      String sub=req.getParameter("sub");
	      String sal=req.getParameter("sal");
	      
	      double sal1=Double.parseDouble(sal);
	      
	      Teacher t=new Teacher();
	      t.setName(name);
	      t.setSubject(sub);
	      t.setSal(sal1);
	      
	        EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.persist(t);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.print("Teacher Details Inserted Successfully!");
			pw.print("Thank you!");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("TeacherCRUD.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		
	}
}