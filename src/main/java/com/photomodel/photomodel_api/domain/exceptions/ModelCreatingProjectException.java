package com.photomodel.photomodel_api.domain.exceptions;

public class ModelCreatingProjectException extends Exception{

    public ModelCreatingProjectException() {
        super("Cannot create project as Model");
    }
}
