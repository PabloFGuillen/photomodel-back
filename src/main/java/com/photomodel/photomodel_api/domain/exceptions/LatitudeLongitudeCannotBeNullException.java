package com.photomodel.photomodel_api.domain.exceptions;

public class LatitudeLongitudeCannotBeNullException extends Exception{

    public LatitudeLongitudeCannotBeNullException() {
        super("Latitude and Longitude Cannot Be Null");
    }
}
