package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.exceptions.DistanceCannotBeNullException;
import com.photomodel.photomodel_api.domain.exceptions.LatitudeLongitudeCannotBeNullException;
import com.photomodel.photomodel_api.infrastructure.views.ProjectView;

import java.time.Instant;
import java.util.List;

public interface ListProjectsUseCase {

    List<ProjectView> getProjectList(Integer page, String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude) throws DistanceCannotBeNullException, LatitudeLongitudeCannotBeNullException;

}
