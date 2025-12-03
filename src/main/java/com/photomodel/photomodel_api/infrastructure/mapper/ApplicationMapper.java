package com.photomodel.photomodel_api.infrastructure.mapper;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.infrastructure.jpa.ApplicationJpaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationMapper {


    public ApplicationJpaEntity toEntity(Application application){
        ApplicationJpaEntity applicationJpaEntity = new ApplicationJpaEntity();
        applicationJpaEntity.setId(application.getId());
        applicationJpaEntity.setRole(application.getRole());
        applicationJpaEntity.setStatus(application.getStatus());
        applicationJpaEntity.setUserId(application.getUserId());
        applicationJpaEntity.setProjectId(application.getProjectId());
        applicationJpaEntity.setApplicationDate(application.getApplicationDate());
        return applicationJpaEntity;
    }

    public Application toDomain(ApplicationJpaEntity applicationJpa){
        Application application = new Application();
        application.setId(applicationJpa.getId());
        application.setRole(applicationJpa.getRole());
        application.setStatus(applicationJpa.getStatus());
        application.setUserId(applicationJpa.getUserId());
        application.setProjectId(applicationJpa.getProjectId());
        application.setApplicationDate(applicationJpa.getApplicationDate());
        return application;
    }

    public List<Application> toDomainList(List<ApplicationJpaEntity> applicationJpaList) {
        List<Application> applicationList = new ArrayList<>();
        for(ApplicationJpaEntity applicationJpa: applicationJpaList){
            Application application = toDomain(applicationJpa);
            applicationList.add(application);
        }
        return applicationList;
    }
}
