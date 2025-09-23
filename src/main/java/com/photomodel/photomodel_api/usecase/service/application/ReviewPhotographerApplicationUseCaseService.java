package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewPhotographerApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewPhotographerApplicationUseCaseService implements ReviewPhotographerApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public List<Application> ReviewPhotographerApplicationUseCase(String proyectId) {
        return applicationRepository.getProyectApplications(proyectId, UserRole.PHOTOGRAPHER.name());
    }
}
