package com.recruitment.task.domain.presentation;

public class RestError {

    private final String message;

    public RestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
