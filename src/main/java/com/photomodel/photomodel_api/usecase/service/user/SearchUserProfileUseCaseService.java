package com.photomodel.photomodel_api.usecase.service.user;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.infrastructure.views.UserView;
import com.photomodel.photomodel_api.usecase.port.input.user.SearchUserUseCase;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchUserProfileUseCaseService implements SearchUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserView> searchUsersByUsername(String username) {
        List<User> userList = userRepository.searchUsersByUsername(username);
        List<UserView> userViews = new ArrayList<>();
        for (User user : userList) {
            UserView view = new UserView();
            view.setId(user.getId());
            view.setUsername(user.getUsername());
            view.setRole(user.getRole());
            view.setLevel(user.getLevel());
            userViews.add(view);
        }
        return userViews;
    }



}
