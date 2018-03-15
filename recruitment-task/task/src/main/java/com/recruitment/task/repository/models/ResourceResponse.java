package com.recruitment.task.repository.models;

public class ResourceResponse {

    private final String body;

    public ResourceResponse(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
