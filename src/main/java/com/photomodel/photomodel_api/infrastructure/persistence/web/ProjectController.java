package com.photomodel.photomodel_api.infrastructure.persistence.web;

import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.GetProjectDetailsUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private CreateProjectUseCase createProjectUseCase;

    @Autowired
    private GetProjectDetailsUseCase getProjectDetailsUseCase;

    @Autowired
    private ListProjectsUseCase projectsUseCase;


}
