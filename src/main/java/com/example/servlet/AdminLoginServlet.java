package com.example.servlet;

import com.example.dao.UserDAO;
import com.example.model.AdminUser;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Use DAO to query admin user data
        UserDAO userDAO = new UserDAO();
        AdminUser adminUser = userDAO.getAdminUser(username, password);

        if (adminUser != null) {
            // Login success, redirect to admin dashboard
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            // Login failure, redirect back to login page
            response.sendRedirect("admin-login.jsp");
        }
    }
}
