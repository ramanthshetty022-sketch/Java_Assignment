/*
6c. Build a servlet program to check the given number is prime number or not using HTML with step by step procedure.
*/
package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Get number from form
            int number = Integer.parseInt(request.getParameter("number"));

            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            boolean isPrime = true;
            String steps = "Checking divisibility:<br>";

            if (number <= 1) {
                isPrime = false;
                steps += number + " is not prime (numbers ≤ 1 are not prime)";
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    steps += number + " % " + i + " = " + (number % i) + "<br>";
                    if (number % i == 0) {
                        isPrime = false;
                        steps += "Divisible by " + i + " → Not Prime<br>";
                        break;
                    }
                }
                if (isPrime) {
                    steps += "No divisors found → Prime Number";
                }
            }

            // HTML response
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prime Result</title>");
            out.println("<style>");
            out.println(".container { margin:20px; padding:20px; width:500px; border:1px solid #ccc; border-radius:5px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + number + "</p>");
            out.println("<p>Result: " + (isPrime ? "Prime Number" : "Not a Prime Number") + "</p>");
            out.println("<p>" + steps + "</p>");

            out.println("<a href='index.html'>Check Another Number</a>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid number");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {

        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");
        out.println("<div style='margin:20px; color:red;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}