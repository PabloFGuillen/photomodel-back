package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
import com.photomodel.photomodel_api.domain.exceptions.ProhibitedModicationOnUserException;
import com.photomodel.photomodel_api.domain.exceptions.UserNotFoundException;
import com.photomodel.photomodel_api.infrastructure.views.CreateUserView;
import com.photomodel.photomodel_api.usecase.port.input.user.CreateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.input.user.UpdateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import com.photomodel.photomodel_api.utils.JasyptUtils;
import com.photomodel.photomodel_api.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCaseService implements UpdateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void updateUserUseCase(CreateUserView user) throws UserNotFoundException, ProhibitedModicationOnUserException, ExistingUserException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();
        User userInBBDD = userRepository.getUserById(((User) auth.getPrincipal()).getId());

        if(!userInBBDD.getId().equals(authenticatedUser.getId())){
            throw new ProhibitedModicationOnUserException();
        }

        if(!userInBBDD.getUsername().equals(user.getUsername())){
            Boolean existsUsername = userRepository.existsUserByUsername(user.getUsername());
            if(existsUsername){
                throw new ExistingUserException(ErrorMessageConstants.EXISTING_USER_ERROR);
            }
            userInBBDD.setUsername(user.getUsername());
        }

        if(!userInBBDD.getEmail().equals(user.getEmail())){
            Boolean existsEmail = userRepository.existsUserByEmail(user.getEmail());
            if(existsEmail){
                throw new ExistingUserException(ErrorMessageConstants.EXISTING_EMAIL_ERROR);
            }
            userInBBDD.setEmail(user.getEmail());
            userInBBDD.setEmailValidated(false);
        }

        userRepository.updateUser(userInBBDD);
    }
}
