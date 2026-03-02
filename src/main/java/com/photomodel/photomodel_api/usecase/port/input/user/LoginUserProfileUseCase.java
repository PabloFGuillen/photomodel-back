package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.LoginFailedException;
import com.photomodel.photomodel_api.infrastructure.views.LoginApiKeyView;

public interface LoginUserProfileUseCase {

    LoginApiKeyView loginUserProfileUseCase(String username, String password) throws LoginFailedException;
}
