package com.photomodel.photomodel_api.domain.exceptions;

public class CreateUserObligatoryInformationNotSettedExeption extends Exception{

    public CreateUserObligatoryInformationNotSettedExeption() {
        super("Please enter obligatory Fields | Username, Email, Password, Role, Level");
    }
}
