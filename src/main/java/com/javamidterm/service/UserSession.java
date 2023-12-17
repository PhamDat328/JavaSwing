package com.javamidterm.service;

public class UserSession {
    private static UserSession instance;
    private String username;
    private String role;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserInfo(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
    
    public boolean isAdmin() {
        return "ADMIN".equals(role);
    }

    public boolean isManager() {
        return "MANAGER".equals(role);
    }

    public boolean isEmployee() {
        return "EMPLOYEE".equals(role);
    }

    public boolean canEditContent() {
        return isAdmin() || isManager();
    }
}
