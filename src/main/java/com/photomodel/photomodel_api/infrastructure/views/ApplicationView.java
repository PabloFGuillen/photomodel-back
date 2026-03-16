package com.photomodel.photomodel_api.infrastructure.views;

import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.data.annotation.Id;

import java.time.Instant;

public class ApplicationView {

    @Id
    private String id;

    private UserView user;

    private ProjectStatus status;

    private UserRole role;

    private Instant applicationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Instant getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Instant applicationDate) {
        this.applicationDate = applicationDate;
    }
}
