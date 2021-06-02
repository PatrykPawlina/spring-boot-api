package com.java.springbootapplication.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.java.springbootapplication.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    ADMIN(Sets.newHashSet(CAR_VIEW, CAR_ADD, CAR_UPDATE, CAR_DELETE)),
    USER(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}