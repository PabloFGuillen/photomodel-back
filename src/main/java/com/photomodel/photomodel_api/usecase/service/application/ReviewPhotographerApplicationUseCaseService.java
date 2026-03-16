package com.photomodel.photomodel_api.usecase.service.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ProjectNotFromUserException;
import com.photomodel.photomodel_api.infrastructure.views.ApplicationView;
import com.photomodel.photomodel_api.infrastructure.views.UserView;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewPhotographerApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ApplicationRepository;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewPhotographerApplicationUseCaseService implements ReviewPhotographerApplicationUseCase {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ApplicationView> getOpenModelApplicationsToProjectUseCase(String projectId) throws ProjectNotFromUserException {
        List<ApplicationView> applicationViewList = new ArrayList<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();

        Project project = projectRepository.getProject(projectId);
        if (project.getUserId().equals(authenticatedUser.getId())){
            List<Application> applicationList = applicationRepository.getPendingApplicationsToProjectUseCase(projectId, UserRole.PHOTOGRAPHER);
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            for(Application application: applicationList) {
                ApplicationView applicationView = new ApplicationView();
                applicationView.setApplicationDate(application.getApplicationDate());
                applicationView.setRole(application.getRole());
                applicationView.setStatus(application.getStatus());
                applicationView.setId(application.getId());
                User user = userRepository.getUserById(application.getUserId());
                UserView userView = objectMapper.convertValue(user, UserView.class);
                applicationView.setUser(userView);
                applicationViewList.add(applicationView);
            }

        } else {
            throw new ProjectNotFromUserException();
        }

        return applicationViewList;
    }
}
