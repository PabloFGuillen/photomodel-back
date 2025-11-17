package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.JoinProjectAsPhotographerUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JoinProjectAsPhotographerUseCaseService implements JoinProjectAsPhotographerUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void JoinProjectAsPhotographerUseCase(String projectId, String userId) {
        Application application = new Application();
        application.setRole(UserRole.PHOTOGRAPHER);
        application.setUserId(userId);
        application.setStatus(ProjectStatus.PENDING);
        application.setApplicationDate(Instant.now().toEpochMilli());
        application.setProjectId(projectId);
        applicationRepository.insertApplication(application);
    }
}
