package com.RTM.services.authentication.domain.model;

import java.util.Set;

public class SecureUser {

    private int id;
    private String username;
    private String name;
    private Set access;
    private boolean isActive;

    public SecureUser(int id, String username, String name, Set access, boolean isActive) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.access = access;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getAccess() {
        return access;
    }

    public void setAccess(Set access) {
        this.access = access;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
