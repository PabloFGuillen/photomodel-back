package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.exceptions.ModelCreatingProjectException;
import com.photomodel.photomodel_api.domain.exceptions.ValidationException;
import com.photomodel.photomodel_api.infrastructure.views.CreateProjectView;
import com.photomodel.photomodel_api.infrastructure.views.ProjectView;
import com.photomodel.photomodel_api.usecase.port.input.project.CreateProjectUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.GetProjectDetailsUseCase;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private CreateProjectUseCase createProjectUseCase;

    @Autowired
    private GetProjectDetailsUseCase getProjectDetailsUseCase;

    @Autowired
    private ListProjectsUseCase listProjectsUseCase;

    @PostMapping("")
    public ResponseEntity<HttpStatus> saveProject(@RequestBody CreateProjectView createProjectView) throws ValidationException, ModelCreatingProjectException {
        createProjectUseCase.createProjectUseCase(createProjectView);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjectView>> getProjectsList(@RequestParam("title") String title,
                                                             @RequestParam("username") String username,
                                                             @RequestParam("distance") Integer distances,
                                                             @RequestParam("paid") Boolean paid,
                                                             @RequestParam("date")Instant date,
                                                             @RequestParam("latitude") Double latitude,
                                                             @RequestParam("longitude") Double longitude){
        return new ResponseEntity<>(listProjectsUseCase.getProjectList(title, username, distances, paid, date, latitude, longitude), HttpStatus.OK);
    }

}
