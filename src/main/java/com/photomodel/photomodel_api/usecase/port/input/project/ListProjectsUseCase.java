package com.photomodel.photomodel_api.usecase.port.input.project;

import com.photomodel.photomodel_api.domain.Project;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ListProjectsUseCase {

    List<Project> getProjectList(Double latitude, Double longitude, Integer kilometers);

}
