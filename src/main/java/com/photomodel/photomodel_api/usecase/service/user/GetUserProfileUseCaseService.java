package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.user.GetUserProfileUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserProfileUseCaseService implements GetUserProfileUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserProfileById(String userId) {
        User user = userRepository.getUserById(userId);
        return user;
    }



}
