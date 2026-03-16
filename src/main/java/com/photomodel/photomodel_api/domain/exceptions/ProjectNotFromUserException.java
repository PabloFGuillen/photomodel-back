package com.photomodel.photomodel_api.domain.exceptions;

public class ProjectNotFromUserException extends Exception{

    public ProjectNotFromUserException() {
        super("Project Not Created By User");

    }
}
