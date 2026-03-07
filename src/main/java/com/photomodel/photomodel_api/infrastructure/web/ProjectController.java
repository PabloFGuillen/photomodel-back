package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.infrastructure.views.CreateProjectView;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.GetProjectDetailsUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private CreateProjectUseCase createProjectUseCase;

    @Autowired
    private GetProjectDetailsUseCase getProjectDetailsUseCase;

    @Autowired
    private ListProjectsUseCase projectsUseCase;

    @PostMapping("")
    public ResponseEntity<HttpStatus> saveProject(@RequestBody CreateProjectView createProjectView) throws ValidationException {
        createProjectUseCase.createProjectUseCase(createProjectView);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
