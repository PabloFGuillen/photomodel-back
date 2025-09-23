package com.photomodel.photomodel_api.infrastructure.persistence.repository;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.infrastructure.persistence.jpa.repo.ApplicationJpaRepository;
import com.photomodel.photomodel_api.infrastructure.persistence.mapper.ApplicationMapper;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationJpaRepository applicationJpaRepository;

    @Override
    public void insertApplication(Application application) {

    }

    @Override
    public Application getApplication(String applicationId) {
        return null;
    }

    @Override
    public void updateApplication(Application application) {

    }

    @Override
    public List<Application> getProyectApplications(String proyectId, String role) {
        return null;
    }
}
