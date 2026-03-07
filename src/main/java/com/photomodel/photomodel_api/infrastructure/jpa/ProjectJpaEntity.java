package com.photomodel.photomodel_api.infrastructure.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "Project")
public class ProjectJpaEntity {

    @Id
    private String id;

    private String title;

    private String description;

    private String location;


    private GeoJsonPoint geoLocation;

    private Instant date;

    private boolean paidProject;

    private String userId;

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
}
