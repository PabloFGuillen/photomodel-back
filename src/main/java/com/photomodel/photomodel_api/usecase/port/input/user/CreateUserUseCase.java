package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface CreateUserUseCase {

    User createUser(String id, String username, String email, String password, Enum level, Enum rol);
}
