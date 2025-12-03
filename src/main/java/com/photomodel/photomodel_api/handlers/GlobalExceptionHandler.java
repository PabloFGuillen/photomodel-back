package com.photomodel.photomodel_api.handlers;

import com.photomodel.photomodel_api.domain.exceptions.ExistingUserException;
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

}
