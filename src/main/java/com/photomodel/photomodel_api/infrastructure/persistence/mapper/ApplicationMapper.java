package com.photomodel.photomodel_api.infrastructure.persistence.mapper;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.ApplicationJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {


    public ApplicationJpaEntity toEntity(Application application){
        ApplicationJpaEntity applicationJpaEntity = new ApplicationJpaEntity();
        applicationJpaEntity.setId(application.getId());
        applicationJpaEntity.setRole(application.getRole());
        applicationJpaEntity.setStatus(application.getStatus());
        applicationJpaEntity.setUserId(application.getUserId());
        applicationJpaEntity.setProyectId(application.getProyectId());
        applicationJpaEntity.setApplicationDate(application.getApplicationDate());
        return applicationJpaEntity;
    }

    public Application toDomain(ApplicationJpaEntity applicationJpa){
        Application application = new Application();
        application.setId(applicationJpa.getId());
        application.setRole(applicationJpa.getRole());
        application.setStatus(applicationJpa.getStatus());
        application.setUserId(applicationJpa.getUserId());
        application.setProyectId(applicationJpa.getProyectId());
        application.setApplicationDate(applicationJpa.getApplicationDate());
        return application;
    }
}
