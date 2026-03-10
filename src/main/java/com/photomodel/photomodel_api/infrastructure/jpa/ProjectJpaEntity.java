package com.photomodel.photomodel_api.infrastructure.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "Project")
public class ProjectJpaEntity {

    @Id
    private String id;

    private String title;

    private String description;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint geoLocation;

    private Instant date;

    private Boolean paidProject;

    private String userId;

    private Boolean closedProject = false;

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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getPaidProject() {
        return paidProject;
    }

    public void setPaidProject(Boolean paidProject) {
        this.paidProject = paidProject;
    }

    public Boolean getClosedProject() {
        return closedProject;
    }

    public void setClosedProject(Boolean closedProject) {
        this.closedProject = closedProject;
    }
}
