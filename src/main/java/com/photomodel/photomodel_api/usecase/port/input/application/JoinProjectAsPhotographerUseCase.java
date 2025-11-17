package com.photomodel.photomodel_api.usecase.port.input.application;

import org.springframework.stereotype.Service;

public interface JoinProjectAsPhotographerUseCase {

    void JoinProjectAsPhotographerUseCase(String projectId, String userId);
}
