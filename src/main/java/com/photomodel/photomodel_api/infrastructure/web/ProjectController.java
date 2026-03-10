package com.photomodel.photomodel_api.infrastructure.web;

import com.photomodel.photomodel_api.domain.exceptions.DistanceCannotBeNullException;
import com.photomodel.photomodel_api.domain.exceptions.LatitudeLongitudeCannotBeNullException;
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
    public ResponseEntity<List<ProjectView>> getProjectsList(@RequestParam(value = "title", required = false) String title,
                                                             @RequestParam(value = "username", required = false) String username,
                                                             @RequestParam(value = "distance", required = true) Integer distances,
                                                             @RequestParam(value = "paid", required = false) Boolean paid,
                                                             @RequestParam(value = "date", required = false)Instant date,
                                                             @RequestParam(value = "latitude", required = true) Double latitude,
                                                             @RequestParam(value = "longitude", required = true) Double longitude,
                                                             @RequestParam(value = "page", required = false) Integer page) throws DistanceCannotBeNullException, LatitudeLongitudeCannotBeNullException {
        return new ResponseEntity<>(listProjectsUseCase.getProjectList(page, title, username, distances, paid, date, latitude, longitude), HttpStatus.OK);
    }

}
