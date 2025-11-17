package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectUseCaseService implements CreateProjectUseCase {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProjectUseCase(Project project) {
        projectRepository.insertProject(project);
    }
}
