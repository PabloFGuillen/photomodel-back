package com.photomodel.photomodel_api.infrastructure.mapper;

import com.photomodel.photomodel_api.domain.Location;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.infrastructure.jpa.ProjectJpaEntity;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {

    public ProjectJpaEntity toEntity(Project project){
        ProjectJpaEntity projectJpaEntity = new ProjectJpaEntity();
        projectJpaEntity.setId(project.getId());
        projectJpaEntity.setPaidProject(project.isPaidProject());
        projectJpaEntity.setUserId(project.getUserId());
        projectJpaEntity.setDescription(project.getDescription());
        projectJpaEntity.setTitle(project.getTitle());
        projectJpaEntity.setDate(project.getDate());
        Location location = project.getLocation();
        if(location != null){
            GeoJsonPoint geoJsonPoint = new GeoJsonPoint(location.getLongitude(), location.getLatitude());
            projectJpaEntity.setGeoLocation(geoJsonPoint);
        }

        return projectJpaEntity;
    }

    public Project toDomain(ProjectJpaEntity projectJpaEntity){
        Project project = new Project();
        projectJpaEntity.setId(project.getId());
        projectJpaEntity.setPaidProject(project.isPaidProject());
        projectJpaEntity.setUserId(project.getUserId());
        projectJpaEntity.setDescription(project.getDescription());
        projectJpaEntity.setTitle(project.getTitle());
        projectJpaEntity.setDate(project.getDate());

        GeoJsonPoint geoJsonPoint = projectJpaEntity.getGeoLocation();
        if(geoJsonPoint != null){
            Location location = new Location();
            location.setLatitude(geoJsonPoint.getY());
            location.setLongitude(geoJsonPoint.getX());
            project.setLocation(location);
        }
        return project;
    }

    public List<Project> toDomainList(List<ProjectJpaEntity> projectEntityList){
        List<Project> projectList = new ArrayList<>();
        for(ProjectJpaEntity projectJpaEntity: projectEntityList){
            Project project = toDomain(projectJpaEntity);
            projectList.add(project);
        }
        return projectList;
    }
}