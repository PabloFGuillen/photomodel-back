package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.Proyect;
import org.springframework.stereotype.Service;

@Service
public interface CreateProjectUseCase {

    void createProjectUseCase(Proyect project);
}
