package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.infrastructure.views.ProjectView;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListProjectsUseCaseService implements ListProjectsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectView> getProjectList(String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude) {
        List<Project> project = projectRepository.getProjectListNearLocation(title, username, distances, paid, date, latitude, longitude);
        if(distances != null){

        }

        if(latitude != null && longitude != null){

        }
        return new ArrayList<>();
    }
}
