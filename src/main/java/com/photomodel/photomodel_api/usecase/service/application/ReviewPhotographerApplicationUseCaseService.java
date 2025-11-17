package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewPhotographerApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewPhotographerApplicationUseCaseService implements ReviewPhotographerApplicationUseCase {

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public List<Application> ReviewPhotographerApplicationUseCase(String projectId) {
        return projectRepository.getProjectApplications(projectId, UserRole.PHOTOGRAPHER.name());
    }
}
