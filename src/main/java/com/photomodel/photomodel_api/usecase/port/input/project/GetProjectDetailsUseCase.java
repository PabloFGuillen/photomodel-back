package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.Project;
import org.springframework.stereotype.Service;

public interface GetProjectDetailsUseCase {

    Project getProjectDetailUseCase(String projectId);

}
