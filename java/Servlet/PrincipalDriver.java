package Servlet;

import java.io.IOException;

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

import Entity.Principal;
@WebServlet("/signup")
public class PrincipalDriver extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
	    String email=req.getParameter("email");
	    String mobile=	req.getParameter("mobile");
		String age=req.getParameter("age");
		String pass=req.getParameter("pass");
		
		int age1=Integer.parseInt(age);
		long mobile1=Long.parseLong(mobile);
		
		Principal p =new Principal();
		p.setName(name);
		p.setEmail(email);
		p.setMobileNo(mobile1);
		p.setAge(age1);
		p.setPassword(pass);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		System.out.println("Data Inserted Sucessfully!");
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		
		
		
		
	}
	
}