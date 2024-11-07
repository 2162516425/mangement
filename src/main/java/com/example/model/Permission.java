package com.example.model;

public class Permission {
    private int permissionID;
    private String permissionType;

    public Permission(int permissionID, String permissionType) {
        this.permissionID = permissionID;
        this.permissionType = permissionType;
    }

    // Getter 和 Setter
    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }
}

