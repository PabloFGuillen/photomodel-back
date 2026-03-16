package com.photomodel.photomodel_api.usecase.service.application;


import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ApplicationDoesNotExistException;
import com.photomodel.photomodel_api.domain.exceptions.CannotModifyApplicationException;
import com.photomodel.photomodel_api.infrastructure.views.ApplicationView;
import com.photomodel.photomodel_api.usecase.port.input.application.AcceptApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcceptApplicationUseCaseService implements AcceptApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void acceptApplicationUseCase(String applicationId) throws ApplicationDoesNotExistException, CannotModifyApplicationException {
        List<ApplicationView> applicationViewList = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();
        Application application = applicationRepository.getApplication(applicationId);

        if(application == null){
            Project project = projectRepository.getProject(application.getId());
            if (project.getUserId().equals(authenticatedUser.getId())) {
                application.setStatus(ProjectStatus.ACCEPTED);
                applicationRepository.updateApplication(application);

            } else {
                throw new CannotModifyApplicationException(ErrorMessageConstants.CAN_NOT_DENY_APPLICATION_FROM_A_PROJECT_NOT_FROM_USER);
            }
        } else {
            throw new ApplicationDoesNotExistException();
        }
    }
}
