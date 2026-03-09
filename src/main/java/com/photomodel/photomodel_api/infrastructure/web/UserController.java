package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.*;
import com.photomodel.photomodel_api.infrastructure.views.CreateUserView;
import com.photomodel.photomodel_api.infrastructure.views.LoginApiKeyView;
import com.photomodel.photomodel_api.infrastructure.views.UserView;
import com.photomodel.photomodel_api.usecase.port.input.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private SearchUserUseCase searchUserUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private UploadPhotoUserCase uploadPhotoUserCase;

    @Autowired
    private LoginUserProfileUseCase loginUserProfileUseCase;

    @Autowired
    private GetUserUseCase getUserUseCase;

    @PostMapping("")
    private ResponseEntity<HttpStatus> createUser(@RequestBody() User createUserView) throws ExistingUserException, ValidationException {
        createUserUseCase.createUser(createUserView.getUsername(), createUserView.getEmail(), createUserView.getPassword(), createUserView.getLevel(), createUserView.getRole());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/login")
    private ResponseEntity<LoginApiKeyView> getUserProfileUseCase(@RequestParam("username") String username, @RequestParam("password") String password) throws LoginFailedException {
        return new ResponseEntity<>(loginUserProfileUseCase.loginUserProfileUseCase(username, password), HttpStatus.OK);
    }

    @PutMapping("")
    private ResponseEntity<String> updateUserProfileCase(@RequestBody() CreateUserView updateUserView) throws UserNotFoundException, ProhibitedModicationOnUserException, ExistingUserException {
        updateUserUseCase.updateUserUseCase(updateUserView);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    private ResponseEntity<List<UserView>> getUserInfoView(@RequestParam String username){
        List<UserView> userList = searchUserUseCase.searchUsersByUsername(username);

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    private ResponseEntity<UserView> getUserByUsername(@PathVariable(value = "username") String username) throws UserNotFoundException {
            return new ResponseEntity<>(getUserUseCase.getUserByUsername(username), HttpStatus.OK);
    }


}
