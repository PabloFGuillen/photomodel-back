package com.photomodel.photomodel_api.usecase.port.input.application;

import org.springframework.stereotype.Service;

@Service
public interface JoinProjectAsModelUseCase {

    void joinProjectAsModelUseCase(String proyect, String userId);
}
