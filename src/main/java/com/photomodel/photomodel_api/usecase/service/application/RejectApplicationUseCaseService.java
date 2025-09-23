package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.RejectApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejectApplicationUseCaseService implements RejectApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void rejectApplicationUseCase(String applicationId) {
        Application application = applicationRepository.getApplication(applicationId);
        application.setStatus(ProjectStatus.REJECTED);
        applicationRepository.updateApplication(application);
    }
}
