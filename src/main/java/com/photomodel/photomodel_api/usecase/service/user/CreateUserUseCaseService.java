package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import com.photomodel.photomodel_api.utils.JasyptUtils;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.user.CreateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import com.photomodel.photomodel_api.utils.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseService implements CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JasyptUtils jasyptUtils;

    public User createUser(String username, String email, String password, UserType level, UserRole rol) throws ExistingUserException, ValidationException {

        User user = null;
        if(username != null && email != null && password != null && level != null && rol != null){
            boolean existsUsername = userRepository.existsUserByUsername(username);
            boolean existsEmail = userRepository.existsUserByEmail(email);
            if(!existsUsername && !existsEmail){
                password = jasyptUtils.encryptPassword(password);
                user = new User(null, username, email, password, level, rol, false, null);
                userRepository.save(user);
            } else {
                if(existsEmail) {
                    throw new ExistingUserException(ErrorMessageConstants.EXISTING_EMAIL_ERROR);

                } else {
                    throw new ExistingUserException(ErrorMessageConstants.EXISTING_USER_ERROR);
                }
            }

        } else {
            throw new ValidationException(ErrorMessageConstants.CREATE_USER_VALIDATION_ERROR);
        }

        return user;
    }
}
