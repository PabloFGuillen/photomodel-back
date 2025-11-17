package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import org.springframework.stereotype.Service;

public interface CreateUserUseCase {

    User createUser(String username, String email, String password, Enum level, Enum rol) throws Exception;
}
