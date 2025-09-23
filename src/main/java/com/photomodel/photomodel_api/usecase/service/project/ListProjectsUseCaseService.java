package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Proyect;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListProjectsUseCaseService implements ListProjectsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Proyect> getProyectList(Double latitude, Double longitude, Integer kilometers) {
        return projectRepository.getProyectListNearLocation(latitude, longitude, kilometers);
    }
}
