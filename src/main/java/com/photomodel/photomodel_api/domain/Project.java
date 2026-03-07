package com.photomodel.photomodel_api.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Project {

    private String id;

    private String title;

    private String description;

    private Location location;

    private Instant date;

    private boolean paidProject = false;

    private String userId;

    public Project() {
    }

    public Project(String id, String title, String description, Location location, Instant date, boolean paidProject, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.paidProject = paidProject;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public boolean isPaidProject() {
        return paidProject;
    }

    public void setPaidProject(boolean paidProject) {
        this.paidProject = paidProject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
