package com.example.model;


public class ManagerUser extends User {

    public ManagerUser(String username, String password, Role role, String contact) {
        super(username, password, role, contact);
    }

    // 查看所有排班
    public void viewAllSchedules() {
        // 实现查看所有排班的逻辑
    }

    // 批准排班
    public void approveSchedule(Schedule schedule) {
        // 实现批准排班的逻辑
    }
}


