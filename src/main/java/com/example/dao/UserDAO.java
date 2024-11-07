package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.AdminUser;
import com.example.model.Role;
import com.example.model.User;

import java.sql.*;

public class UserDAO {

    // Existing method to get regular user by username
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM User WHERE username=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("userID");
                String password = rs.getString("password");
                int roleID = rs.getInt("roleID");
                String contact = rs.getString("contact");

                Role role = new RoleDAO().getRoleById(roleID);
                user = new User(username, password, role, contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }

        return user;
    }

    // New method to get an admin user by username and password
    public AdminUser getAdminUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AdminUser adminUser = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM User WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("userID");
                String contact = rs.getString("contact");
                int roleID = rs.getInt("roleID");

                // Use RoleDAO to get the role name
                Role role = new RoleDAO().getRoleById(roleID);

                // Check if the user has admin role
                if ("admin".equalsIgnoreCase(role.getRoleName())) { // Check for "admin" role
                    adminUser = new AdminUser(username, password, role, contact);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }

        return adminUser;
    }

    // Helper method to close database resources
    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}
