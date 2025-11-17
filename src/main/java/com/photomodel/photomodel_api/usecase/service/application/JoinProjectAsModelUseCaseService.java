package com.photomodel.photomodel_api.usecase.service.application;


import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.JoinProjectAsModelUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JoinProjectAsModelUseCaseService implements JoinProjectAsModelUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public void joinProjectAsModelUseCase(String project, String userId) {
        Application application = new Application();
        application.setProjectId(project);
        application.setUserId(userId);
        application.setApplicationDate(Instant.now().toEpochMilli());
        application.setStatus(ProjectStatus.PENDING);
        application.setRole(UserRole.MODEL);
        applicationRepository.insertApplication(application);

    }
}
