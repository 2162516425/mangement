package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Employee;

import java.sql.*;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Employee (name, position, contactInfo) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getPosition());
            stmt.setString(3, employee.getContactInfo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}

