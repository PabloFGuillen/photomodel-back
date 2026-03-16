package com.photomodel.photomodel_api.usecase.service.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.application.JoinProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.enums.ProjectStatus;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JoinProjectUseCaseService implements JoinProjectUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public void joinProjectAsUseCase(String projectId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();

        Project project = projectRepository.getProject(projectId);
        if(project.getUserId().equals(authenticatedUser.getId())){

            Application applicationInBBDD = applicationRepository.getApplicationByUserIdAndProject(authenticatedUser.getId(), projectId);
            if(applicationInBBDD != null) {
                if(authenticatedUser.getRole().equals(UserRole.PHOTOGRAPHER)){
                    Application application = new Application();
                    application.setRole(UserRole.PHOTOGRAPHER);
                    application.setUserId(authenticatedUser.getId());
                    application.setStatus(ProjectStatus.PENDING);
                    application.setApplicationDate(Instant.now());
                    application.setProjectId(projectId);
                    applicationRepository.insertApplication(application);

                } else if(authenticatedUser.getRole().equals(UserRole.MODEL)){
                    Application application = new Application();
                    application.setProjectId(projectId);
                    application.setUserId(authenticatedUser.getId());
                    application.setApplicationDate(Instant.now());
                    application.setStatus(ProjectStatus.PENDING);
                    application.setRole(UserRole.MODEL);
                    applicationRepository.insertApplication(application);
                }
            }

        }
    }
}
