<%--
7b. Construct a Cookie Management program using JSP to get the fields Name, Domain and Max Expiry Age ( in sec) and press the button Add Cookie for displaying the set cookie information.
Then it has to go to show the active cookie list when you press the link go to the active cookie list
--%>
<!-- File: showcookies.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(int i = 0; i < cookies.length; i++){
        out.print("Cookie Name : " + cookies[i].getName() + "<br>");
        out.print("Value : " + cookies[i].getValue() + "<br><br>");
    }
}else{
    out.print("No Cookies Found");
}
%>

</body>
</html>