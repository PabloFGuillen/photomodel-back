package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Proyect;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateProjectUseCaseService implements CreateProjectUseCase {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProjectUseCase(Proyect project) {
        projectRepository.insertProyect(project);
    }
}
