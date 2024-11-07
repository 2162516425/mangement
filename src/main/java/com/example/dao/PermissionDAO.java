package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Permission;

import java.sql.*;

public class PermissionDAO {
    public Permission getPermissionById(int permissionID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Permission permission = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Permission WHERE permissionID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, permissionID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String permissionType = rs.getString("permissionType");
                permission = new Permission(permissionID, permissionType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return permission;
    }
}

