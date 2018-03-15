package com.recruitment.task.repository.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recruitment.task.repository.models.RepositoryResource;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubResource extends RepositoryResource {

    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final int stars;
    private ZonedDateTime createdAt;

    @JsonCreator
    public GithubResource(@JsonProperty("full_name") String fullName,
                          @JsonProperty("description") String description,
                          @JsonProperty("clone_url") String cloneUrl,
                          @JsonProperty("stargazers_count") int stars,
                          @JsonProperty("created_at") ZonedDateTime createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
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

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
