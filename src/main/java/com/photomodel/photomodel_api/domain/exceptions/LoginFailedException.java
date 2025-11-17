package com.photomodel.photomodel_api.domain.exceptions;

public class LoginFailedException extends  Exception{

    public LoginFailedException(){
        super("Username or Password incorrect");
    }
}
