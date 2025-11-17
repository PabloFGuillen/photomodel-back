package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.Application;

import java.util.List;

public interface ReviewPhotographerApplicationUseCase {

    List<Application> ReviewPhotographerApplicationUseCase(String projectId);
}
