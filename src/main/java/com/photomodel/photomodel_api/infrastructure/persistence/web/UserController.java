package com.photomodel.photomodel_api.infrastructure.persistence.web;

import com.photomodel.photomodel_api.infrastructure.persistence.views.CreateUserView;
import com.photomodel.photomodel_api.usecase.port.input.user.CreateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.input.user.GetUserProfileUseCase;
import com.photomodel.photomodel_api.usecase.port.input.user.UpdateUserUseCase;
import com.photomodel.photomodel_api.usecase.port.input.user.UploadPhotoUserCase;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    private ResponseEntity<HttpStatus> createUser(@RequestBody() CreateUserView createUserView) throws Exception {
        createUserUseCase.createUser(createUserView.getUserName(), createUserView.getEmail(), createUserView.getPassword(), createUserView.getLevel(), createUserView.getRole());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    private ResponseEntity<HttpStatus> getUserProfileUseCase(@RequestParam String username ){
        return null;
    }
}
