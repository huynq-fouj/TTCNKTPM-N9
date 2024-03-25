package com.example.cinemaweb.enums;

public enum UserRole {
    USER("user"), ADMIN("admin");

    private final String ROLE;

    UserRole(String role) {
        this.ROLE = role;
    }

    public String getROLE() {
        return this.ROLE;
    }
}
