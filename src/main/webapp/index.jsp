<%-- File: index.jsp --%>
<%--
10.a Build an Application to get Username, Email and Designation through JSP called index.jsp
with client sided validation and submit to the servlet called UserDataServlet.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Data Form</title>
<style>
.form-container {
    width: 300px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
}
.form-field {
    margin: 10px 0;
}
</style>

<script>
function validateForm() {
    let username = document.getElementById("username").value.trim();
    let email = document.getElementById("email").value.trim();
    let designation = document.getElementById("designation").value.trim();

    if (username === "") {
        alert("Username is required");
        return false;
    }
    if (!email.includes("@")) {
        alert("Enter valid email");
        return false;
    }
    if (designation === "") {
        alert("Designation is required");
        return false;
    }
    return true;
}
</script>
</head>
<body>

<div class="form-container">
<h2>Enter User Data</h2>

<form action="processUser" method="POST" onsubmit="return validateForm()">

<div class="form-field">
<label>Username :</label>
<input type="text" id="username" name="username">
</div>

<div class="form-field">
<label>Email :</label>
<input type="text" id="email" name="email">
</div>

<div class="form-field">
<label>Designation :</label>
<input type="text" id="designation" name="designation">
</div>

<div class="form-field">
<input type="submit" value="Submit">
</div>

</form>
</div>

</body>
</html>