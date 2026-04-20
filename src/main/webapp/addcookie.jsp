<%--
7b. Construct a Cookie Management program using JSP to get the fields Name, Domain and Max Expiry Age ( in sec) and press the button Add Cookie for displaying the set cookie information.
Then it has to go to show the active cookie list when you press the link go to the active cookie list
--%>
<!-- File: addcookie.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Cookie</title>
</head>
<body>

<%
String name = request.getParameter("cname");
String domain = request.getParameter("cdomain");
int age = Integer.parseInt(request.getParameter("cage"));

Cookie ck = new Cookie(name, domain);
ck.setMaxAge(age);
response.addCookie(ck);

out.print("<h3>Cookie Added Successfully</h3>");
out.print("Name : " + name + "<br>");
out.print("Domain : " + domain + "<br>");
out.print("Max Age : " + age + " seconds<br>");
%>

<br>
<a href="showcookies.jsp">Go to Active Cookie List</a>

</body>
</html>