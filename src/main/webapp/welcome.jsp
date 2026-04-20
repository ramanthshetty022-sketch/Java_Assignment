<%--
9.c Build a Session Management using JSP program for getting session expiry time and your name through text box and press submit to display the message by greeting Hello your name!. press the following link to check it within the set session time or wait there for the minutes set to see the session expiry.
--%>
<!-- File: welcome.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>

<%
    String name = request.getParameter("uname");
    int time = Integer.parseInt(request.getParameter("stime"));

    out.print("Hello " + name);
    out.print("<br>Session has started for " + name);

    session.setAttribute("user", name);
    session.setMaxInactiveInterval(time);

    out.print("<br>Session expiry time set to " + time + " seconds");

    out.print("<br>Click below within the time or wait to test expiry<br>");
%>

<a href="second.jsp">Check Session</a>

</body>
</html>