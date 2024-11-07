package com.example.servlet;

import com.example.dao.ScheduleDAO;
import com.example.model.Schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class ScheduleManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 初始化 ScheduleDAO，并获取所有排班数据
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        List<Schedule> schedules = null;

        try {
            // 获取所有排班数据，如果需要分页可以在这里处理
            schedules = scheduleDAO.getAllSchedules();
        } catch (Exception e) {
            // 发生数据库或其他错误时处理
            e.printStackTrace();
            request.setAttribute("errorMessage", "获取排班数据时发生错误。");
        }

        // 如果获取到排班数据，将其设置到请求属性中
        if (schedules != null) {
            request.setAttribute("schedules", schedules);
        }

        // 转发请求到 manage-schedule.jsp 页面进行显示
        RequestDispatcher dispatcher = request.getRequestDispatcher("manage-schedule.jsp");
        dispatcher.forward(request, response);
    }

    // 如果未来需要支持POST请求或其他操作，可以在这里添加相关的方法
}
