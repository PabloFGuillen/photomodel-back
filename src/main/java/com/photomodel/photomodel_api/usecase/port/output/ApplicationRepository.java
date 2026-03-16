package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Application;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Application")
public interface ApplicationRepository {

    void insertApplication(Application application);

    Application getApplication(String applicationId);

    void updateApplication(Application application);

    Application getApplicationByUserIdAndProject(String userId, String projectId);

    List<Application> getPendingApplicationsToProjectUseCase(String projectId, UserRole userRole);
}
