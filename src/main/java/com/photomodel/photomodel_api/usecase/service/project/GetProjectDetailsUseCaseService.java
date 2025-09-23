package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Proyect;
import com.photomodel.photomodel_api.usecase.port.input.project.GetProjectDetailsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GetProjectDetailsUseCaseService implements GetProjectDetailsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Proyect getProyectDetailUseCase(String proyectId) {
        return projectRepository.getProyect(proyectId);
    }
}
