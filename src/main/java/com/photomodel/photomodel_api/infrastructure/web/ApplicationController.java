package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.exceptions.ApplicationDoesNotExistException;
import com.photomodel.photomodel_api.domain.exceptions.CannotModifyApplicationException;
import com.photomodel.photomodel_api.domain.exceptions.ProjectNotFromUserException;
import com.photomodel.photomodel_api.infrastructure.views.ApplicationView;
import com.photomodel.photomodel_api.usecase.port.input.application.*;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController {


    @Autowired
    private JoinProjectUseCase joinProjectUseCase;

    @Autowired
    private AcceptApplicationUseCase acceptApplicationUseCaseService;

    @Autowired
    private RejectApplicationUseCase rejectApplicationUseCaseService;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/join/{project}")
    public ResponseEntity<HttpStatus> joinProjectAsPhotographer(@PathVariable(value = "project") String projectId){

        joinProjectUseCase.joinProjectAsUseCase(projectId);


        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/reject/{applicationId}")
    public ResponseEntity<HttpStatus> rejectApplicationToProject(@PathVariable(value = "applicationId") String applicationId) throws ApplicationDoesNotExistException, CannotModifyApplicationException, ProjectNotFromUserException {

        rejectApplicationUseCaseService.rejectApplicationUseCase(applicationId);


        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/accept/{applicationId}")
    public ResponseEntity<HttpStatus> acceptApplicationToProject(@PathVariable(value = "applicationId") String applicationId) throws ApplicationDoesNotExistException, CannotModifyApplicationException, ProjectNotFromUserException {

        acceptApplicationUseCaseService.acceptApplicationUseCase(applicationId);


        return new ResponseEntity<>(HttpStatus.OK);

    }


}
