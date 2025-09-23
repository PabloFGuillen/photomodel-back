package com.photomodel.photomodel_api.usecase.service.application;


import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.usecase.port.input.application.AcceptApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class AcceptApplicationUseCaseService implements AcceptApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public void acceptApplicationUseCase(String applicationId) {
        Application application = applicationRepository.getApplication(applicationId);
        application.setStatus(ProjectStatus.ACCEPTED);
        applicationRepository.updateApplication(application);
    }
}
