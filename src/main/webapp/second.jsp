<%--
9.c Build a Session Management using JSP program for getting session expiry time and your name through text box and press submit to display the message by greeting Hello your name!. press the following link to check it within the set session time or wait there for the minutes set to see the session expiry.
--%>
<!-- File: second.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Session Check</title>
</head>
<body>

<h2>Session Status</h2>

<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
        out.print("Sorry, session has expired");
    } else {
        out.print("Hello " + name + ", your session is still active");
    }
%>

</body>
</html>