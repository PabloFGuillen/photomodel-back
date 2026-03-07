package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.LoginFailedException;
import com.photomodel.photomodel_api.infrastructure.views.LoginApiKeyView;
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
    public LoginApiKeyView loginUserProfileUseCase(String username, String password) throws LoginFailedException {

        User user = userRepository.getUserByUsername(username);

        if(user == null){
            throw new LoginFailedException();
        }

        String decryptedUserPassword = jasyptUtils.decryptPassword(user.getPassword());;
        if(!decryptedUserPassword.equals(password)){
            throw new LoginFailedException();
        }

        return new LoginApiKeyView(jwtUtil.generateToken(user));
    }
}
