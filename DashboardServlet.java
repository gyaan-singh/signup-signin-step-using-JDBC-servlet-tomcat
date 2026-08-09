package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("userId") == null) {

            response.sendRedirect("signin.html");
            return;
        }

        String name = (String) session.getAttribute("userName");
        String email = (String) session.getAttribute("userEmail");

        response.setContentType("text/html");

        response.getWriter().println(
            "<html>" +
            "<head><title>User Dashboard</title></head>" +
            "<body>" +
            "<h1>Welcome, " + name + "!</h1>" +
            "<p>Email: " + email + "</p>" +
            "<h2>User Dashboard</h2>" +
            "<p>You are successfully logged in.</p>" +
            "<a href='logout'>Logout</a>" +
            "</body>" +
            "</html>"
        );
    }
          }
