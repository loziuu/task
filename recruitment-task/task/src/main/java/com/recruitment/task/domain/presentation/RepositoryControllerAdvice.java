package com.recruitment.task.domain.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class RepositoryControllerAdvice {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<RestError> handleHttpClientErrorException(HttpClientErrorException ex) {
        String message = getRestErrorMessageBasedOnStatusCode(ex);
        RestError restError = new RestError(message);
        return ResponseEntity.status(ex.getStatusCode()).body(restError);
    }

    private String getRestErrorMessageBasedOnStatusCode(HttpClientErrorException ex) {
        if (ex.getStatusCode().equals(HttpStatus.NOT_FOUND))
            return "Requested repository does not exist.";
        return ex.getMessage();
    }
}
