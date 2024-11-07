package com.example.model;

public class User {
    private int userID;
    private String username;
    private String password;
    private Role role;
    private String contact;

    // 构造函数
    public User(String username, String password, Role role, String contact) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.contact = contact;
    }

    // 登录和登出方法
    public void login() {
        // 登录逻辑
    }

    public void logout() {
        // 登出逻辑
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

