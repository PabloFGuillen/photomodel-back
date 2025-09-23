package com.photomodel.photomodel_api.usecase.port.input.application;

import org.springframework.stereotype.Service;

@Service
public interface JoinProjectAsPhotographerUseCase {

    void JoinProjectAsPhotographerUseCase(String proyectId, String userId);
}
