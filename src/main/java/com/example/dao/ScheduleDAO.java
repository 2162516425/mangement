package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    // Add a new schedule
    public boolean addSchedule(Schedule schedule) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Schedule (employeeID, date, time, location) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schedule.getEmployeeID());
            stmt.setDate(2, new java.sql.Date(schedule.getDate().getTime())); // Convert Date to java.sql.Date
            stmt.setString(3, schedule.getTime());
            stmt.setString(4, schedule.getLocation());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }

        return success;
    }

    // Update an existing schedule
    public boolean updateSchedule(Schedule schedule) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "UPDATE Schedule SET employeeID=?, date=?, time=?, location=? WHERE scheduleID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, schedule.getEmployeeID());
            stmt.setDate(2, new java.sql.Date(schedule.getDate().getTime()));
            stmt.setString(3, schedule.getTime());
            stmt.setString(4, schedule.getLocation());
            stmt.setInt(5, schedule.getScheduleID());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }

        return success;
    }

    // Delete a schedule
    public boolean deleteSchedule(int scheduleID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean success = false;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM Schedule WHERE scheduleID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, scheduleID);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }

        return success;
    }

    // Get all schedules for an employee
    public List<Schedule> getSchedulesByEmployeeID(int employeeID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Schedule> schedules = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Schedule WHERE employeeID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleID(rs.getInt("scheduleID"));
                schedule.setEmployeeID(rs.getInt("employeeID"));
                schedule.setDate(rs.getDate("date"));
                schedule.setTime(rs.getString("time"));
                schedule.setLocation(rs.getString("location"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }

        return schedules;
    }

    // Get a specific schedule by ID
    public Schedule getScheduleByID(int scheduleID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Schedule schedule = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Schedule WHERE scheduleID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                schedule = new Schedule();
                schedule.setScheduleID(rs.getInt("scheduleID"));
                schedule.setEmployeeID(rs.getInt("employeeID"));
                schedule.setDate(rs.getDate("date"));
                schedule.setTime(rs.getString("time"));
                schedule.setLocation(rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }

        return schedule;
    }

    // 获取所有排班数据
    public List<Schedule> getAllSchedules() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Schedule> schedules = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Schedule";  // 如果需要筛选某些排班，可以在这里修改SQL
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleID(rs.getInt("scheduleID"));
                schedule.setEmployeeID(rs.getInt("employeeID"));
                schedule.setDate(rs.getDate("date"));
                schedule.setTime(rs.getString("time"));
                schedule.setLocation(rs.getString("location"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }

        return schedules;
    }
    // Helper method to close database resources
    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }

    // Helper method to close database resources (for non-ResultSet operations)
    private void closeResources(PreparedStatement stmt, Connection conn) {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}
