package com.photomodel.photomodel_api.infrastructure.views;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class CreateProjectView {

    private String title;

    private String description;

    private String location;


    private GeoJsonPoint geoLocation;

    private Long date;

    private boolean paidProject;

    private String userId;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GeoJsonPoint getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoJsonPoint geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
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
}
