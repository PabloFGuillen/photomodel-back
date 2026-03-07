package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.UserNotFoundException;
import com.photomodel.photomodel_api.infrastructure.views.UserView;
import com.photomodel.photomodel_api.usecase.port.input.user.GetUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import com.photomodel.photomodel_api.utils.ErrorMessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserUseCaseService implements GetUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserView getUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user != null){
            UserView view = new UserView();
            view.setId(user.getId());
            view.setUsername(user.getUsername());
            view.setRole(user.getRole());
            view.setLevel(user.getLevel());
            return view;

        } else {
            throw new UserNotFoundException(username);
        }
    }
}
