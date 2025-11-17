package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProjectsUseCaseService implements ListProjectsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getProjectList(Double latitude, Double longitude, Integer kilometers) {
        return projectRepository.getProjectListNearLocation(latitude, longitude, kilometers);
    }
}
