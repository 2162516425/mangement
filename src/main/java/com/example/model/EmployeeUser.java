package com.example.model;

public class EmployeeUser extends User {

    public EmployeeUser(String username, String password, Role role, String contact) {
        super(username, password, role, contact);
    }

    // 查看个人排班
    public void viewPersonalSchedule() {
        // 实现查看个人排班的逻辑
    }

    // 接收通知
    public void receiveNotification(Notification notification) {
        // 实现接收通知的逻辑
    }
}

