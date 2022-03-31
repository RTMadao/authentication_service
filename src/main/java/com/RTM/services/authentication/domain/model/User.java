package com.RTM.services.authentication.domain.model;

import java.util.Set;

public class User {

    private int id;
    private String username;
    private String password;
    private String name;
    private Set access;

    public User(int id, String username, String password, String name, Set access) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.access = access;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecureUser getSecureUser(){return new SecureUser(this.id, this.username, this.name, this.access);}

    public Set getAccess() {
        return access;
    }

    public void setAccess(Set access) {
        this.access = access;
    }
}
