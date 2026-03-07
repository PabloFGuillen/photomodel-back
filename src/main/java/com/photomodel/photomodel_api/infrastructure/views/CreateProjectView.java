package com.photomodel.photomodel_api.infrastructure.views;

import com.photomodel.photomodel_api.domain.Location;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.Instant;

public class CreateProjectView {

    private String title;

    private String description;

    private Location location;

    private Instant date;

    private boolean paidProject = false;

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

    public boolean isPaidProject() {
        return paidProject;
    }

    public void setPaidProject(boolean paidProject) {
        this.paidProject = paidProject;
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
}
