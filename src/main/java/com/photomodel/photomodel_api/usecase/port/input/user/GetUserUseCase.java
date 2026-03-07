package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.exceptions.UserNotFoundException;
import com.photomodel.photomodel_api.infrastructure.views.UserView;

public interface GetUserUseCase {

    UserView getUserByUsername(String username) throws UserNotFoundException;
}
