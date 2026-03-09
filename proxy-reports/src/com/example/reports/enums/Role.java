package com.example.reports.enums;

public enum Role {
    STUDENT,
    FACULTY,
    ADMIN;

    public static Role getRole(String role) {
        return switch (role) {
            case "STUDENT" -> STUDENT;
            case "FACULTY" -> FACULTY;
            case "ADMIN" -> ADMIN;
            default -> null;
        };
    }
}
