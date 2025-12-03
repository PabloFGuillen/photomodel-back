package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import com.photomodel.photomodel_api.utils.enums.UserType;
import org.springframework.stereotype.Service;

public interface CreateUserUseCase {

    User createUser(String username, String email, String password, UserType level, UserRole rol) throws ExistingUserException;
}
