package com.photomodel.photomodel_api.infrastructure.mapper;

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
        if(project.getLatitude() != null && project.getLatitude() != null){
            GeoJsonPoint geoJsonPoint = new GeoJsonPoint(project.getLongitude(), project.getLatitude());
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
        if(projectJpaEntity.getGeoLocation() != null){
            GeoJsonPoint geoJsonPoint = projectJpaEntity.getGeoLocation();
            project.setLatitude(geoJsonPoint.getY());
            project.setLongitude(geoJsonPoint.getX());
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