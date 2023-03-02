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

@WebServlet("/update")
public class TeacherUpdate  extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		  String id4=req.getParameter("id3");
		  String name=req.getParameter("name1");
	      String sub=req.getParameter("sub1");
	      String sal2=req.getParameter("sal1");
	      
	      int id5=Integer.parseInt(id4);
	      double sal3=Double.parseDouble(sal2);
	      
	      Teacher t=new Teacher();
	      t.setId(id5);
	      t.setName(name);
	      t.setSubject(sub);
	      t.setSal(sal3);
	      
	      et.begin();
	      em.merge(t);
	      et.commit();
	      
	      PrintWriter pw=resp.getWriter();
	      pw.print("Teacher details updated successfully!");
	      pw.print("Thank you!");
	      
	      RequestDispatcher rd=req.getRequestDispatcher("TeacherCRUD.html");
	      rd.include(req, resp);
	      resp.setContentType("text/html");
	}
}