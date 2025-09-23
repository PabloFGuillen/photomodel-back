package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.utils.JasyptUtils;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.user.CreateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUserUseCaseService implements CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JasyptUtils jasyptUtils;
    public User createUser(String id, String username, String email, String password, Enum level, Enum rol){

        User user = null;
        if(!userRepository.existsUserByEmailOrUsername(email, username)){
            password = jasyptUtils.encryptPassword(password);
            user = new User(id, username, email, password, level, rol);
            userRepository.save(user);
        }

        return user;
    }
}
