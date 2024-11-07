package com.example.model;

import java.util.Date;

public class Notification {
    private int notificationID;
    private String message;
    private Date date;
    private int status;

    public Notification(int notificationID, String message, Date date, int status) {
        this.notificationID = notificationID;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    // 标记为已读
    public void markAsRead() {
        this.status = 1; // 假设 1 表示已读
    }

    // Getter 和 Setter
    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

