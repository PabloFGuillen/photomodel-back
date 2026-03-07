package com.photomodel.photomodel_api.usecase.service.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.infrastructure.views.CreateProjectView;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectUseCaseService implements CreateProjectUseCase {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProjectUseCase(CreateProjectView createProjectView) throws ValidationException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();

        if(createProjectView.getDate() != null && createProjectView.getLocation() != null
                && createProjectView.getTitle() != null){
            ObjectMapper objectMapper = new ObjectMapper();
            Project project = objectMapper.convertValue(createProjectView, Project.class);
            project.setId(authenticatedUser.getId());
            projectRepository.insertProject(project);

        } else {
            throw new ValidationException(ErrorMessageConstants.CREATE_PROJECT_VALIDATION_ERROR);
        }
    }
}
