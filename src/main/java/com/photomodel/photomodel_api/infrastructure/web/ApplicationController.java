package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.input.application.*;
import com.photomodel.photomodel_api.utils.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private AcceptApplicationUseCase acceptApplicationUseCaseService;

    @Autowired
    private JoinProjectAsPhotographerUseCase joinAsPhotographer;

    @Autowired
    private JoinProjectAsModelUseCase joinProjectAsModel;

    @Autowired
    private RejectApplicationUseCase rejectApplicationUseCaseService;

    @Autowired
    private ReviewModelApplicationUseCase reviewModelApplicationUseCase;

    @Autowired
    private ReviewPhotographerApplicationUseCase photographerApplicationUseCase;

    @PostMapping("/join/{project}")
    public ResponseEntity<HttpStatus> JoinProjectAsPhotographer(@PathVariable(value = "project") String projectId){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) auth.getPrincipal();
        if(authenticatedUser.getRole().equals(UserRole.PHOTOGRAPHER)){
            joinAsPhotographer.joinProjectAsPhotographerUseCase(projectId, authenticatedUser.getId());

        } else if(authenticatedUser.getRole().equals(UserRole.MODEL)){
            joinProjectAsModel.joinProjectAsModelUseCase(projectId, authenticatedUser.getId());

        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
