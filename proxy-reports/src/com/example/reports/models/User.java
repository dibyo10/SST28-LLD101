package com.example.reports.models;

import com.example.reports.enums.Role;

public class User {
    private final String name;
    private final Role role;

    public User(String name, String role) {
        this.name = name;
        this.role = Role.getRole(role);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return this.role.toString();
    }
}