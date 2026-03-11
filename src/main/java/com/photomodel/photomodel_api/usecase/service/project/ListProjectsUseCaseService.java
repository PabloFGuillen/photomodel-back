package com.photomodel.photomodel_api.usecase.service.project;

import com.photomodel.photomodel_api.domain.Project;
import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.domain.exceptions.DistanceCannotBeNullException;
import com.photomodel.photomodel_api.domain.exceptions.LatitudeLongitudeCannotBeNullException;
import com.photomodel.photomodel_api.infrastructure.views.ProjectView;
import com.photomodel.photomodel_api.infrastructure.views.UserView;
import com.photomodel.photomodel_api.usecase.port.input.project.ListProjectsUseCase;
import com.photomodel.photomodel_api.usecase.port.output.ProjectRepository;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListProjectsUseCaseService implements ListProjectsUseCase {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProjectView> getProjectList(Integer page, String title, String username, Integer distances, Boolean paid, Instant date, Double latitude, Double longitude) throws DistanceCannotBeNullException, LatitudeLongitudeCannotBeNullException {
        if(distances == null){
            throw new DistanceCannotBeNullException();
        }

        if(latitude == null && longitude == null){
            throw new LatitudeLongitudeCannotBeNullException();

        }

        List<ProjectView> projectViews = new ArrayList<>();
        if(page == null){
            page = 0;
        }
        List<Project> projectList = projectRepository.getProjectListNearLocation(page, title, username, distances, paid, date, latitude, longitude);

        for(Project project: projectList){
            User user = userRepository.getUserById(project.getUserId());
            UserView userView = setUserView(user);
            ProjectView projectView = setProjectView(project, userView);
            projectViews.add(projectView);
        }

         return projectViews;
    }

    private static UserView setUserView(User user) {
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setUsername(user.getUsername());
        userView.setRole(user.getRole());
        userView.setLevel(user.getLevel());
        return userView;
    }

    private static ProjectView setProjectView(Project project, UserView userView) {
        ProjectView projectView = new ProjectView();
        projectView.setId(project.getId());
        projectView.setPaidProject(project.getPaidProject());
        projectView.setDescription(project.getDescription());
        projectView.setTitle(project.getTitle());
        projectView.setDate(project.getDate());
        projectView.setLocation(project.getLocation());
        projectView.setPaidProject(project.getClosedProject());

        projectView.setUser(userView);
        return projectView;
    }
}
