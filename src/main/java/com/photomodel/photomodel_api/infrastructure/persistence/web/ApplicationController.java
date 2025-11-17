package com.photomodel.photomodel_api.infrastructure.persistence.web;

import com.photomodel.photomodel_api.usecase.port.input.application.ReviewModelApplicationUseCase;
import com.photomodel.photomodel_api.usecase.port.input.application.ReviewPhotographerApplicationUseCase;
import com.photomodel.photomodel_api.usecase.service.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    private AcceptApplicationUseCaseService acceptApplicationUseCaseService;

    @Autowired
    private JoinProjectAsPhotographerUseCaseService joinProjectAsPhotographerUseCaseService;

    @Autowired
    private JoinProjectAsModelUseCaseService joinProjectAsModelUseCaseService;

    @Autowired
    private RejectApplicationUseCaseService rejectApplicationUseCaseService;

    @Autowired
    private ReviewModelApplicationUseCase reviewModelApplicationUseCase;

    @Autowired
    private ReviewPhotographerApplicationUseCase photographerApplicationUseCase;
}
