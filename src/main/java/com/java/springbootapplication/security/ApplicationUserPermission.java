package com.java.springbootapplication.security;

public enum ApplicationUserPermission {
    CAR_VIEW("car:view"),
    CAR_ADD("car:add"),
    CAR_UPDATE("car:update"),
    CAR_DELETE("car:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}