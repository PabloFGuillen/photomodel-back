package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;

public interface GetUserProfileUseCase {

    User getUserProfileById(Long userId);
}
