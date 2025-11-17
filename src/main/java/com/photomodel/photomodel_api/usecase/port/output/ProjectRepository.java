package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Project")

public interface ProjectRepository {

    void insertProject(Project project);

    Project getProject(String projectId);

    List<Project> getProjectListNearLocation(Double latitude, Double longitude, Integer kilometers);

    List<Application> getProjectApplications(String projectId, String role);
}
