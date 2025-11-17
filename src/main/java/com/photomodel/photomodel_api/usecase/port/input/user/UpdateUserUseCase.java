package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import org.springframework.stereotype.Service;

public interface UpdateUserUseCase {

    void updateUserUseCase(User user);
}
