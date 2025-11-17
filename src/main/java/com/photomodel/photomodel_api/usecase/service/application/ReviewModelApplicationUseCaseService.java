package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewModelApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewModelApplicationUseCaseService implements ReviewModelApplicationUseCase {

    @Autowired
    private ProjectRepository applicationRepository;

    @Override
    public List<Application> ReviewModelApplicationUseCase(String projectId) {
        return applicationRepository.getProjectApplications(projectId, UserRole.MODEL.name());
    }
}
