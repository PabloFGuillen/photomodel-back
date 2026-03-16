package com.photomodel.photomodel_api.usecase.port.input.application;

import com.photomodel.photomodel_api.domain.exceptions.ApplicationDoesNotExistException;
import com.photomodel.photomodel_api.domain.exceptions.CannotModifyApplicationException;
import org.springframework.stereotype.Service;

public interface AcceptApplicationUseCase {

    void acceptApplicationUseCase(String applicationId) throws ApplicationDoesNotExistException, CannotModifyApplicationException;
}
