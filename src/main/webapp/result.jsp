<%-- File: result.jsp --%>
<%--
10.a Display all the data through result.jsp with a link to move back to client side.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result Page</title>
<style>
.result-container {
    width: 300px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
}
.message {
    color: green;
}
.error {
    color: red;
}
</style>
</head>
<body>

<div class="result-container">
<h2>Processing Result</h2>

<%
String message = (String) request.getAttribute("message");
boolean isError = message != null && message.startsWith("Error");
%>

<div class="<%= isError ? "error" : "message" %>">
<%= message %>
</div>

<% if (!isError) { %>
<h3>Submitted Data:</h3>
<p>Username: <%= request.getAttribute("username") %></p>
<p>Email: <%= request.getAttribute("email") %></p>
<p>Designation: <%= request.getAttribute("designation") %></p>
<% } %>

<a href="index.jsp">Back to Form</a>

</div>

</body>
</html>