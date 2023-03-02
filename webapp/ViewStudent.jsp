<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Entity.Student"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
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
<h1>Student Details</h1>
<%   
Student s=(Student)session.getAttribute("studentlist");
%>
<table cellpadding="15px" align="center" border="4">
 
 <th>id</th>
 <th>name</th>
 <th>mobile</th>
 <th>branch</th>
 <tr>
 <td> <%=s.getId() %> </td>
 <td> <%=s.getName() %> </td>
 <td> <%=s.getMobile() %> </td>
 <td> <%=s.getBranch() %> </td>
 </tr>
 </table> <br> <br>
 <div class="main">
<a href="StudentCRUD.html">Back</a>
</div>
</body>
</html>