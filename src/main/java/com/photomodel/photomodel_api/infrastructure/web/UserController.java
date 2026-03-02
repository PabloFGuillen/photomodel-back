package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
import com.photomodel.photomodel_api.domain.exceptions.LoginFailedException;
import com.photomodel.photomodel_api.domain.exceptions.UserNotFoundException;
import com.photomodel.photomodel_api.infrastructure.views.LoginApiKeyView;
import com.photomodel.photomodel_api.usecase.port.input.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetUserProfileUseCase getUserProfileUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private UploadPhotoUserCase uploadPhotoUserCase;

    @Autowired
    private LoginUserProfileUseCase loginUserProfileUseCase;

    @PostMapping("")
    private ResponseEntity<HttpStatus> createUser(@RequestBody() User createUserView) throws ExistingUserException {
        createUserUseCase.createUser(createUserView.getUsername(), createUserView.getEmail(), createUserView.getPassword(), createUserView.getLevel(), createUserView.getRole());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/login")
    private ResponseEntity<LoginApiKeyView> getUserProfileUseCase(@RequestParam("username") String username, @RequestParam("password") String password) throws LoginFailedException {
        return new ResponseEntity<>(loginUserProfileUseCase.loginUserProfileUseCase(username, password), HttpStatus.OK);
    }

    @PutMapping("")
    private ResponseEntity<String> updateUserProfileCase(@RequestBody() User updateUserView) throws UserNotFoundException {
        updateUserUseCase.updateUserUseCase(updateUserView);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
