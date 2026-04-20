<%--
10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result ( Pass if all subjects greater than 40%) and Average marks through result.jsp with a link to move to the client side
--%>
<!-- File: result.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Processing Result</h2>

<p><%= request.getAttribute("message") %></p>

<% if(request.getAttribute("rollno") != null) { %>

    <h3>Student Details</h3>
    Roll No: <%= request.getAttribute("rollno") %><br/>
    Name: <%= request.getAttribute("sname") %><br/>
    Sub1: <%= request.getAttribute("sub1") %><br/>
    Sub2: <%= request.getAttribute("sub2") %><br/>
    Sub3: <%= request.getAttribute("sub3") %><br/>
    Sub4: <%= request.getAttribute("sub4") %><br/>
    Sub5: <%= request.getAttribute("sub5") %><br/>
    Average: <%= request.getAttribute("average") %><br/>
    Result: <%= request.getAttribute("result") %><br/>

<% } %>

<br>
<a href="index.jsp">Back to Form</a>

</body>
</html>