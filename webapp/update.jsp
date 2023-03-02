<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="Entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Teacher</title>
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
Teacher t=em.find(Teacher.class, id2);
%>
<div>
<form action="update" method="post">
id: <input type="text" name="id3" value="<%=t.getId()%>"> <br> <br>
name: <input type="text" name="name1" value="<%=t.getName()%>"> <br> <br>
salary: <input type="text" name="sal1" value="<%=t.getSal()%>"> <br> <br>
subject: <input type="text" name="sub1" value="<%=t.getSubject()%>"><br> <br>
<input type="submit"> <pre><button formaction="TeacherCRUD.html">Back</button></form></pre>
</form>
</div>
</body>
</html>