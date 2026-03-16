package com.photomodel.photomodel_api.infrastructure.repository;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.infrastructure.jpa.ApplicationJpaEntity;
import com.photomodel.photomodel_api.infrastructure.jpa.repo.ApplicationJpaRepository;
import com.photomodel.photomodel_api.infrastructure.mapper.ApplicationMapper;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationJpaRepository applicationJpaRepository;

    @Override
    public void insertApplication(Application application) {
        ApplicationJpaEntity applicationJpaEntity = applicationMapper.toEntity(application);
        applicationJpaRepository.insertApplication(applicationJpaEntity);
    }

    @Override
    public Application getApplication(String applicationId) {
        ApplicationJpaEntity applicationJpaEntity = applicationJpaRepository.getApplication(applicationId);
        return applicationMapper.toDomain(applicationJpaEntity);
    }

    @Override
    public void updateApplication(Application application) {
        ApplicationJpaEntity applicationJpaEntity = applicationMapper.toEntity(application);
        applicationJpaRepository.updateApplication(applicationJpaEntity);

    }

    @Override
    public Application getApplicationByUserIdAndProject(String userId, String projectId) {
        ApplicationJpaEntity applicationJpaEntity = applicationJpaRepository.getApplicationByUserIdAndProject(userId, projectId);

        return applicationMapper.toDomain(applicationJpaEntity);
    }

    @Override
    public List<Application> getPendingApplicationsToProjectUseCase(String projectId) {
        List<ApplicationJpaEntity> applicationJpaEntity = applicationJpaRepository.getPendingApplicationsToProjectUseCase(projectId);

        return applicationMapper.toDomainList(applicationJpaEntity);
    }
}
