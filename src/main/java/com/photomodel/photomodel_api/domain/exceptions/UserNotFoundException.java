package com.photomodel.photomodel_api.domain.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message){
        super("User: " + message + "| Not Found");
    }
}
