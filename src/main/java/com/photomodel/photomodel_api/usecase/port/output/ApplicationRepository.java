package com.photomodel.photomodel_api.usecase.port.output;

import com.photomodel.photomodel_api.domain.Application;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Document(collection = "Application")
public interface ApplicationRepository {

    void insertApplication(Application application);

    Application getApplication(String applicationId);

    void updateApplication(Application application);

}
