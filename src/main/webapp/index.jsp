<%--
10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result ( Pass if all subjects greater than 40%) and Average marks through result.jsp with a link to move to the client side
--%>
<!-- File: index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
    <script>
        function validateForm() {
            let marks = ["sub1","sub2","sub3","sub4","sub5"];
            for (let i = 0; i < marks.length; i++) {
                let val = document.forms["f1"][marks[i]].value;
                if (val === "" || val < 0 || val > 100) {
                    alert("Marks must be between 0 and 100");
                    return false;
                }
            }
            return true;
        }
    </script>
</head>
<body>

<form name="f1" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno" required><br/>
    Student Name: <input type="text" name="sname" required><br/>
    Sub1: <input type="number" name="sub1" required><br/>
    Sub2: <input type="number" name="sub2" required><br/>
    Sub3: <input type="number" name="sub3" required><br/>
    Sub4: <input type="number" name="sub4" required><br/>
    Sub5: <input type="number" name="sub5" required><br/>
    <input type="submit" value="Submit">
</form>

</body>
</html>