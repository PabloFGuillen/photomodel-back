package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.Application;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewModelApplicationUseCase {

    List<Application> ReviewModelApplicationUseCase(String projectId);
}
