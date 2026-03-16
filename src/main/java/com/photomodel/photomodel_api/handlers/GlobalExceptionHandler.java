package com.photomodel.photomodel_api.handlers;

import com.photomodel.photomodel_api.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ExistingUserException.class)
    public ResponseEntity<Map<String, String>> handleExistingUserException(ExistingUserException ex) {
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT) // 409 conflict, perfecto para "ya existe"
                .body(body);
    }

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Map<String, String>> handleLoginFailedException(LoginFailedException ex) {
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);

    }

    @ExceptionHandler(ProhibitedModicationOnUserException.class)
    public ResponseEntity<Map<String, String>> handlerProhibitedModicationOnUserException(ProhibitedModicationOnUserException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);

    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>> handlerCreateUserObligatoryInformationNotSettedExeption(ValidationException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);

    }

    @ExceptionHandler(ModelCreatingProjectException.class)
    public ResponseEntity<Map<String, String>> handlerModelCreatingProjectException(ModelCreatingProjectException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);

    }

    @ExceptionHandler(LatitudeLongitudeCannotBeNullException.class)
    public ResponseEntity<Map<String, String>> handlerLongitudeLatitudeCannotBeNullException(LatitudeLongitudeCannotBeNullException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);

    }

    @ExceptionHandler(DistanceCannotBeNullException.class)
    public ResponseEntity<Map<String, String>> handlerDistanceCannotBeNullException(DistanceCannotBeNullException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);

    }

    @ExceptionHandler(AlredySentApplicationToProjectException.class)
    public ResponseEntity<Map<String, String>> handlerAlredySentApplicationToProjectException(AlredySentApplicationToProjectException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);

    }

    @ExceptionHandler(ProjectNotFromUserException.class)
    public ResponseEntity<Map<String, String>> handlerProjectNotFromUserException(ProjectNotFromUserException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(body);

    }

    @ExceptionHandler(CannotModifyApplicationException.class)
    public ResponseEntity<Map<String, String>> handlerCannotModifyApplicationException(CannotModifyApplicationException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(body);

    }

    @ExceptionHandler(ApplicationDoesNotExistException.class)
    public ResponseEntity<Map<String, String>> handlerApplicationDoesNotExistException(ApplicationDoesNotExistException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(body);

    }
}
