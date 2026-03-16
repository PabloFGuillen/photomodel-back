package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.exceptions.ProjectNotFromUserException;
import com.photomodel.photomodel_api.infrastructure.views.ApplicationView;

import java.util.List;

public interface ReviewPhotographerApplicationUseCase {

    List<ApplicationView> getOpenPhotographerApplicationsToProjectUseCase(String projectId) throws ProjectNotFromUserException;
}
