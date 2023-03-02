<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="Entity.Teacher"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Deatils</title>
<style type="text/css">
.main{
color:white;
background-color: white;
display: inline-block;
border: 2px solid black;
border-radius: 6px;
}
table{
color: black;
}
</style>
</head>
<body bgcolor="white" align="center">
<h1>Teacher Details</h1>
<%   Teacher t=(Teacher)session.getAttribute("teacherlist");
     
%>
<table cellpadding="15px" align="center" border="4">
 
 <th>id</th>
 <th>name</th>
 <th>sal</th>
 <th>Subject</th>
 <tr>
 <td> <%= t.getId() %> </td>
 <td> <%=t.getName() %> </td>
 <td> <%= t.getSal() %> </td>
 <td> <%= t.getSubject() %> </td>
 </tr>
 </table> <br> <br>
 <div class="main">
<a href="TeacherCRUD.html">Back</a>
</div>
 </body>
</html>