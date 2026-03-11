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
        projectJpaEntity.setPaidProject(project.getPaidProject());
        projectJpaEntity.setUserId(project.getUserId());
        projectJpaEntity.setDescription(project.getDescription());
        projectJpaEntity.setTitle(project.getTitle());
        projectJpaEntity.setDate(project.getDate());
        projectJpaEntity.setClosedProject(project.getClosedProject());

        Location location = project.getLocation();
        if(location != null){
            GeoJsonPoint geoJsonPoint = new GeoJsonPoint(location.getLongitude(), location.getLatitude());
            projectJpaEntity.setGeoLocation(geoJsonPoint);
        }

        return projectJpaEntity;
    }

    public Project toDomain(ProjectJpaEntity projectJpaEntity){
        Project project = new Project();
        project.setId(projectJpaEntity.getId());
        project.setPaidProject(projectJpaEntity.getPaidProject());
        project.setUserId(projectJpaEntity.getUserId());
        project.setDescription(projectJpaEntity.getDescription());
        project.setTitle(projectJpaEntity.getTitle());
        project.setDate(projectJpaEntity.getDate());
        project.setPaidProject(projectJpaEntity.getClosedProject());

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