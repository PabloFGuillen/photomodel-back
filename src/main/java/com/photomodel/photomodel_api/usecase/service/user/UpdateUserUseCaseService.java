package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.user.UpdateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserUseCaseService implements UpdateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUserUseCase(User user) {
        userRepository.updateUser(user);
    }
}
