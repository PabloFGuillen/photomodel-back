package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.LoginFailedException;
import com.photomodel.photomodel_api.usecase.port.input.user.LoginUserProfileUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.JasyptUtils;
import com.photomodel.photomodel_api.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserProfileUseCaseService implements LoginUserProfileUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JasyptUtils jasyptUtils;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String loginUserProfileUseCase(String username, String password) throws LoginFailedException {
        String encryptedPassword = jasyptUtils.encryptPassword(password);

        User user = userRepository.loginUser(username, encryptedPassword);

        if(user == null){
            throw new LoginFailedException();
        }

        return jwtUtil.generateToken(user);

    }
}
