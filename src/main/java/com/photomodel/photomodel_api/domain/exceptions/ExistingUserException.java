package com.photomodel.photomodel_api.domain.exceptions;

public class ExistingUserException extends Exception{

    public ExistingUserException(String errorMessage){
        super(errorMessage);
    }
}
