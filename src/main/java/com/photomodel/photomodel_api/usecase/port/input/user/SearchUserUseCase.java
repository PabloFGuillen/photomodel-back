package com.photomodel.photomodel_api.usecase.port.input.user;

import com.photomodel.photomodel_api.infrastructure.views.UserView;

import java.util.List;

public interface SearchUserUseCase {

    List<UserView> searchUsersByUsername(String username);
}
