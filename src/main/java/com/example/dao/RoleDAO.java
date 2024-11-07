package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Role;

import java.sql.*;

public class RoleDAO {

    // Get role by ID (e.g., 1 for admin, 2 for user, etc.)
    public Role getRoleById(int roleID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Role role = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Role WHERE roleID=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roleID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String roleName = rs.getString("roleName");
                role = new Role(roleID, roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return role;
    }
}
