package Servlet;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Principal;
@WebServlet("/login")
public class LoginDriver extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, pass);
		
		List <Principal> principal=q.getResultList();
		
		if(principal.size()>0) {
			PrintWriter pw=resp.getWriter();
			pw.write("Login Sucessfull!");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("option.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else {
			PrintWriter pw=resp.getWriter();
			pw.write("Invalid Credentails!");
			
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}