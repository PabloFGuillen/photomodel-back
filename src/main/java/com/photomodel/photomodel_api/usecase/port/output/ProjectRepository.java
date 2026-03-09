package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.domain.Project;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Project")

public interface ProjectRepository {

    void insertProject(Project project);

    Project getProject(String projectId);

    List<Project> getProjectListNearLocation(String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude);

    List<Application> getProjectApplications(String projectId, String role);
}
