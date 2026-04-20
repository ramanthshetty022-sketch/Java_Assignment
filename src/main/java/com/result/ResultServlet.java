/*
10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result ( Pass if all subjects greater than 40%) and Average marks through result.jsp with a link to move to the client side
*/
// File: ResultServlet.java
package com.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String sname = request.getParameter("sname");

        int sub1 = Integer.parseInt(request.getParameter("sub1"));
        int sub2 = Integer.parseInt(request.getParameter("sub2"));
        int sub3 = Integer.parseInt(request.getParameter("sub3"));
        int sub4 = Integer.parseInt(request.getParameter("sub4"));
        int sub5 = Integer.parseInt(request.getParameter("sub5"));

        String message;

        if (rollno == null || rollno.trim().isEmpty() || sname == null || sname.trim().isEmpty()) {
            message = "Error: All fields are required";
        } else if (sub1 < 0 || sub1 > 100 || sub2 < 0 || sub2 > 100 ||
                   sub3 < 0 || sub3 > 100 || sub4 < 0 || sub4 > 100 ||
                   sub5 < 0 || sub5 > 100) {
            message = "Error: Marks should be between 0 and 100";
        } else {

            int total = sub1 + sub2 + sub3 + sub4 + sub5;
            double avg = total / 5.0;

            String result = (sub1 > 40 && sub2 > 40 && sub3 > 40 && sub4 > 40 && sub5 > 40) ? "Pass" : "Fail";

            request.setAttribute("rollno", rollno);
            request.setAttribute("sname", sname);
            request.setAttribute("sub1", sub1);
            request.setAttribute("sub2", sub2);
            request.setAttribute("sub3", sub3);
            request.setAttribute("sub4", sub4);
            request.setAttribute("sub5", sub5);
            request.setAttribute("average", avg);
            request.setAttribute("result", result);

            message = "Data processed successfully";
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}