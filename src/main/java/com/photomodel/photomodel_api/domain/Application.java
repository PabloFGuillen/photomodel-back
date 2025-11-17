package com.photomodel.photomodel_api.domain;

import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;

public class Application {

    private String id;

    private String userId;

    private String projectId;

    private ProjectStatus status;

    private UserRole role;

    private Long applicationDate;

    public Application() {
    }

    public Application(String id, String userId, String projectId, ProjectStatus status, Long applicationDate) {
        this.id = id;
        this.userId = userId;
        this.projectId = projectId;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Long getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Long applicationDate) {
        this.applicationDate = applicationDate;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
