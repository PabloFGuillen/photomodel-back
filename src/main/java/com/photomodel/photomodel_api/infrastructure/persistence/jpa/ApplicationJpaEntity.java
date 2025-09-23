package com.photomodel.photomodel_api.infrastructure.persistence.jpa;

import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Application")
public class ApplicationJpaEntity {

    @Id
    private String id;

    private String userId;

    private String proyectId;

    private ProjectStatus status;

    private UserRole role;

    private Long applicationDate;

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

    public String getProyectId() {
        return proyectId;
    }

    public void setProyectId(String proyectId) {
        this.proyectId = proyectId;
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

    public Long getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Long applicationDate) {
        this.applicationDate = applicationDate;
    }
}
