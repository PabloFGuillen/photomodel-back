package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.infrastructure.views.ProjectView;

import java.time.Instant;
import java.util.List;

public interface ListProjectsUseCase {

    List<ProjectView> getProjectList(String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude);

}
