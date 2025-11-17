package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import org.springframework.stereotype.Service;

public interface GetUserProfileUseCase {

    User getUserProfile(Long userId);
}
