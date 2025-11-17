package com.photomodel.photomodel_api.usecase.port.input.application;

import org.springframework.stereotype.Service;

public interface JoinProjectAsModelUseCase {

    void joinProjectAsModelUseCase(String project, String userId);
}
