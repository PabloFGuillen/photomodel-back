package com.photomodel.photomodel_api.domain.exceptions;

public class ProhibitedModicationOnUserException extends Exception {

    public ProhibitedModicationOnUserException() {
        super("Cannot Modify Other User");
    }
}
