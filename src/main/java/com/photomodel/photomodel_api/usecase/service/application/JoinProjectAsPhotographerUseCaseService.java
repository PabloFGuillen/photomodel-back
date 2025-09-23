package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.JoinProjectAsPhotographerUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class JoinProjectAsPhotographerUseCaseService implements JoinProjectAsPhotographerUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void JoinProjectAsPhotographerUseCase(String proyectId, String userId) {
        Application application = new Application();
        application.setRole(UserRole.PHOTOGRAPHER);
        application.setUserId(userId);
        application.setStatus(ProjectStatus.PENDING);
        application.setApplicationDate(Instant.now().toEpochMilli());
        application.setProyectId(proyectId);
        applicationRepository.insertApplication(application);
    }
}
