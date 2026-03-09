package com.photomodel.photomodel_api.infrastructure.views;

import com.photomodel.photomodel_api.utils.enums.UserRole;
import com.photomodel.photomodel_api.utils.enums.UserType;

public class CreateUserView {

    private String username;

    private String email;

    private String password;

    private UserType level;

    private UserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getLevel() {
        return level;
    }

    public void setLevel(UserType level) {
        this.level = level;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
