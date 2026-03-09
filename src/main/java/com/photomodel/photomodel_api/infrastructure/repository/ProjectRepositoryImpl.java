package com.photomodel.photomodel_api.infrastructure.repository;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.infrastructure.jpa.ApplicationJpaEntity;
import com.photomodel.photomodel_api.infrastructure.jpa.ProjectJpaEntity;
import com.photomodel.photomodel_api.infrastructure.jpa.repo.ApplicationJpaRepository;
import com.photomodel.photomodel_api.infrastructure.jpa.repo.ProjectJpaRepository;
import com.photomodel.photomodel_api.infrastructure.mapper.ApplicationMapper;
import com.photomodel.photomodel_api.infrastructure.mapper.ProjectMapper;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    private ApplicationJpaRepository applicationJpaRepository;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public void insertProject(Project project) {
        ProjectJpaEntity projectJpaEntity = projectMapper.toEntity(project);
        projectJpaRepository.insertProject(projectJpaEntity);
    }

    @Override
    public Project getProject(String projectId) {
        ProjectJpaEntity project = projectJpaRepository.getProject(projectId);
        return projectMapper.toDomain(project);
    }

    @Override
    public List<Project> getProjectListNearLocation(String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude) {
        List<ProjectJpaEntity> projectJpaEntity = projectJpaRepository.getProjectListNearLocation(title, username, distances, paid, date, latitude, longitude);
        return projectMapper.toDomainList(projectJpaEntity);
    }

    @Override
    public List<Application> getProjectApplications(String projectId, String role) {
        List<ApplicationJpaEntity> applicationJpaList = applicationJpaRepository.getProjectApplications(projectId, role);
        return applicationMapper.toDomainList(applicationJpaList);
    }
}
