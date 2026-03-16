package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.exceptions.ProjectNotFromUserException;
import com.photomodel.photomodel_api.infrastructure.views.ApplicationView;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewModelApplicationUseCase {

    List<ApplicationView> getOpenModelApplicationsToProjectUseCase(String projectId) throws ProjectNotFromUserException;
}
