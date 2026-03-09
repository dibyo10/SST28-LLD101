package com.example.reports.enums;

public enum Classification {
    PUBLIC,
    FACULTY,
    ADMIN;

    public static Classification getRole(String role) {
        return switch (role) {
            case "PUBLIC" -> PUBLIC;
            case "FACULTY" -> FACULTY;
            case "ADMIN" -> ADMIN;
            default -> null;
        };
    }
}
