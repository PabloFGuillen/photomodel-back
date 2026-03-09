package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.exceptions.ModelCreatingProjectException;
import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.infrastructure.views.CreateProjectView;
import org.springframework.stereotype.Service;

public interface CreateProjectUseCase {

    void createProjectUseCase(CreateProjectView project) throws ValidationException, ModelCreatingProjectException;
}
