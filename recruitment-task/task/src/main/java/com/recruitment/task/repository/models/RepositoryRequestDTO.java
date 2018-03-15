package com.recruitment.task.repository.models;

import java.util.Objects;
import java.util.Optional;

public class RepositoryRequestDTO {

    private final String owner;
    private final String repositoryName;

    public RepositoryRequestDTO(String owner, String repositoryName) {
        if (isBlank(owner) | isBlank(repositoryName)) {
            throw new IllegalArgumentException();
        }
        this.owner = owner;
        this.repositoryName = repositoryName;
    }

    private boolean isBlank(String s) {
        Objects.requireNonNull(s);
        return s.trim().isEmpty();
    }

    public String getOwner() {
        return owner;
    }

    public String getRepositoryName() {
        return repositoryName;
    }
}
