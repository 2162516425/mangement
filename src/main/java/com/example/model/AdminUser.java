package com.example.model;

public class AdminUser extends User {

    public AdminUser(String username, String password, Role role, String contact) {
        super(username, password, role, contact);
    }

    public void addEmployee(Employee employee) {
        // 添加员工逻辑
    }

    public void editEmployee(Employee employee) {
        // 编辑员工逻辑
    }

    public void deleteEmployee(Employee employee) {
        // 删除员工逻辑
    }
}

