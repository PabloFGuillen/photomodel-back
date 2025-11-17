package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.LoginFailedException;

public interface LoginUserProfileUseCase {

    String loginUserProfileUseCase(String username, String password) throws LoginFailedException;
}
