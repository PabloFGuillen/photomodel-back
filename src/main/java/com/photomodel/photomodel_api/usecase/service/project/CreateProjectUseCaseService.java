package com.photomodel.photomodel_api.usecase.service.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ModelCreatingProjectException;
import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.infrastructure.views.CreateProjectView;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectUseCaseService implements CreateProjectUseCase {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProjectUseCase(CreateProjectView createProjectView) throws ValidationException, ModelCreatingProjectException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();

        if(authenticatedUser.getRole().equals(UserRole.PHOTOGRAPHER)){
            if(createProjectView.getDate() != null && createProjectView.getLocation() != null
                    && createProjectView.getTitle() != null){
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                Project project = objectMapper.convertValue(createProjectView, Project.class);
                project.setUserId(authenticatedUser.getId());
                projectRepository.insertProject(project);

            } else {
                throw new ValidationException(ErrorMessageConstants.CREATE_PROJECT_VALIDATION_ERROR);
            }
        } else {
            throw new ModelCreatingProjectException();
        }

    }
}
