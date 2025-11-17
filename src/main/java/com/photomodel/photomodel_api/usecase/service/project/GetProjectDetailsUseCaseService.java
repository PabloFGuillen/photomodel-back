package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.usecase.port.input.project.GetProjectDetailsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProjectDetailsUseCaseService implements GetProjectDetailsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project getProjectDetailUseCase(String projectId) {
        return projectRepository.getProject(projectId);
    }
}
