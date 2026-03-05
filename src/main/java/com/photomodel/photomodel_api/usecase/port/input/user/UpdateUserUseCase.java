package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
import com.photomodel.photomodel_api.domain.exceptions.ProhibitedModicationOnUserException;
import com.photomodel.photomodel_api.domain.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

public interface UpdateUserUseCase {

    void updateUserUseCase(User user) throws UserNotFoundException, ProhibitedModicationOnUserException, ExistingUserException;
}
