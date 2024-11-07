package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 输出首页内容
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>员工管理系统</title></head><body>");
        out.println("<h1>欢迎来到员工管理系统</h1>");
        out.println("<a href='admin-login'>管理员登录</a><br>");
        out.println("<a href='employee-login'>员工登录</a><br>");
        out.println("<a href='manage-schedule'>管理排班</a>");
        out.println("</body></html>");
    }
}
