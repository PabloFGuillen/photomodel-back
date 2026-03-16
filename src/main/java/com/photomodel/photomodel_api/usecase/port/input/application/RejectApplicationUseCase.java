package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.exceptions.ApplicationDoesNotExistException;
import com.photomodel.photomodel_api.domain.exceptions.CannotModifyApplicationException;
import com.photomodel.photomodel_api.domain.exceptions.ProjectNotFromUserException;

public interface RejectApplicationUseCase {

    void rejectApplicationUseCase(String applicationId) throws ProjectNotFromUserException, CannotModifyApplicationException, ApplicationDoesNotExistException;

}
