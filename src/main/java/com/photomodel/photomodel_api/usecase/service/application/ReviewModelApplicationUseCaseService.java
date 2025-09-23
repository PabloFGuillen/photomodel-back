package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewModelApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewModelApplicationUseCaseService implements ReviewModelApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> ReviewModelApplicationUseCase(String proyectId) {
        return applicationRepository.getProyectApplications(proyectId, UserRole.MODEL.name());
    }
}
