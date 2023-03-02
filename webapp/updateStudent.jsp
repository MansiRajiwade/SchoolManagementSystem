<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
 <%@page import="Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<style type="text/css">
div{
  border: 3px solid black;
  border-width: 5px;
  border-radius:10px;
  width: 200px;
  margin-left: 570px;
  margin-top: 200px;
  padding: 10px;
}
</style>
</head>
<body align="center" bgcolor="gray">
<%
String id1=request.getParameter("id");
int id2=Integer.parseInt(id1);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("mansi");
EntityManager em=emf.createEntityManager();
Student s=em.find(Student.class, id2);
%>
<div >
<form action="updateStudent" method="post">
Name: <input type="text" placeholder="Enter name" name="name" value="<%=s.getName() %>"> <br> <br>
Mobile No: <input type="tel"t" placeholder="Enter mobileNo" name="mobile" maxlength="10" value="<%=s.getMobile() %>" ><br> <br>
Branch: <input type="text" placeholder="Enter Branch" name="branch" value="<%=s.getBranch() %>" > <br> <br>
<button>Submit</button> <pre><button formaction="StudentCRUD.html">Back</button></form></pre>
</form>
</div>
</body>
</html>