package com.recruitment.task.fixtures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recruitment.task.repository.models.RepositoryResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FakeResource extends RepositoryResource {

    private final String fullName;

    @JsonCreator
    public FakeResource(@JsonProperty("full_name") String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
