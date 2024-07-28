package com.example.hometask46.enums;

public enum ERoles {
    USER,
    ADMIN;

    public String toRoleString() {
        return "ROLE_" + this.name();
    }
}
