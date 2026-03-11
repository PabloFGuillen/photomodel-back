package com.photomodel.photomodel_api.infrastructure.views;

import com.photomodel.photomodel_api.domain.Location;

import java.time.Instant;

public class ProjectView {

    private String id;

    private String title;

    private String description;

    private Location location;

    private Instant date;

    private boolean paidProject = false;

    private UserView user;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }
}
