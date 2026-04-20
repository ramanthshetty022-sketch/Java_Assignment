/*
6b. Build a servlet program to create a cookie to get your name through text box and press submit button (through HTML) to display the message by greeting Welcome back your name ! , you have visited this page n times (n = number of your visit) and demonstrate the expiry of cookie also.
*/
package com.cookieservlet;

//Step 1: Required imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//Step 2: Create servlet class and use WebServlet annotation
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Step 3: Handle GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Step 4: Create or retrieve cookies
        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {

            // Create cookies
            Cookie userCookie = new Cookie("user", userName);
            Cookie countCookie = new Cookie("count", "1");

            // Step 5: Set cookie properties (expiry demo)
            userCookie.setMaxAge(30);   // 30 seconds
            countCookie.setMaxAge(30);  // 30 seconds

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // Step 6: Read cookies
        Cookie[] cookies = request.getCookies();

        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                }

                if (cookie.getName().equals("count")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    visitCount++;

                    cookie.setValue(String.valueOf(visitCount));
                    cookie.setMaxAge(30); // reset expiry
                    response.addCookie(cookie);
                }
            }
        }

        // Step 7: Generate response
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            out.println("<font color=blue><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color=magenta><h2>You have visited this page " + visitCount + " times!</h2></font>");
            out.println("<a href='CookieServlet?logout=true'>Logout</a>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Step 8: Handle logout and cookie expiry
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie userCookie = new Cookie("user", "");
        Cookie countCookie = new Cookie("count", "");

        userCookie.setMaxAge(0);
        countCookie.setMaxAge(0);

        response.addCookie(userCookie);
        response.addCookie(countCookie);

        response.sendRedirect("CookieServlet");
    }
}