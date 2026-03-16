package com.photomodel.photomodel_api.domain.exceptions;

public class ApplicationDoesNotExistException extends Exception{

    public ApplicationDoesNotExistException() {
        super("Application does not exist");
    }
}
