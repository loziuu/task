package com.recruitment.task.domain.models;

import com.recruitment.task.repository.models.GithubResource;

import java.time.ZonedDateTime;

public class RepositoryDetails {

    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final int stars;
    private final ZonedDateTime createdAt;

    public RepositoryDetails(GithubResource resource) {
        this(resource, resource.getCreatedAt());
    }

    public RepositoryDetails(GithubResource resource, ZonedDateTime adjustedCreatedAt) {
        this.fullName = resource.getFullName();
        this.description = resource.getDescription();
        this.cloneUrl = resource.getCloneUrl();
        this.stars = resource.getStars();
        this.createdAt = adjustedCreatedAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public int getStars() {
        return stars;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
