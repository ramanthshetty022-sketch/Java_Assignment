/*
8b. Build a servlet program to create a cookie to get your name through text box and
press submit button( through HTML) to display the message by greeting Welcome back
your name ! , you have visited this page n times ( n = number of your visit ) along with the
list of cookies and its setvalues and demonstrate the expiry of cookie also.
*/
// File: CookieServlet.java
package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        if (userName != null && !userName.isEmpty()) {
            existingUser = userName;
            count = count + 1;

            Cookie userCookie = new Cookie("user", existingUser);
            userCookie.setMaxAge(60);

            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        out.println("<html>");
        out.println("<head><title>Cookie Servlet</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back " + existingUser + "!</h2>");
            out.println("<h3 style='color:magenta;'>You have visited this page " + count + " times</h3>");

            out.println("<h3>List of Cookies with Values:</h3>");
            if (cookies != null) {
                for (Cookie c : cookies) {
                    out.println("Cookie Name: " + c.getName() + "<br>");
                    out.println("Cookie Value: " + c.getValue() + "<br>");
                    out.println("Max Age: " + c.getMaxAge() + "<br><br>");
                }
            }

            out.println("<a href='CookieServlet'>Refresh</a><br>");
            out.println("<a href='CookieServlet?logout=true'>Delete Cookie</a>");

        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name.</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        String logout = request.getParameter("logout");
        if (logout != null) {
            Cookie userCookie = new Cookie("user", "");
            userCookie.setMaxAge(0);

            Cookie countCookie = new Cookie("count", "");
            countCookie.setMaxAge(0);

            response.addCookie(userCookie);
            response.addCookie(countCookie);

            response.sendRedirect("CookieServlet");
        }

        out.println("</body>");
        out.println("</html>");
    }
}