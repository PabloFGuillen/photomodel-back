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
    public ResponseEntity<Map<String, String>> handleExistingUser(ExistingUserException ex) {
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT) // 409 conflict, perfecto para "ya existe"
                .body(body);
    }

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Map<String, String>> handleLoginFailed(ExistingUserException ex) {
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);

    }

    @ExceptionHandler(ProhibitedModicationOnUserException.class)
    public ResponseEntity<Map<String, String>> handlerProhibitedModicationOnUser(ProhibitedModicationOnUserException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);

    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>> handlerCreateUserObligatoryInformationNotSettedExeption(ProhibitedModicationOnUserException ex){
        Map<String, String> body = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);

    }


}
