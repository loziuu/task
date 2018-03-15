package com.recruitment.task.domain;

import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.repository.models.GithubResource;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Baklazan {

    private final TimeZoneConverter timeZoneConverter;

    public Baklazan(TimeZoneConverter timeZoneConverter) {
        this.timeZoneConverter = timeZoneConverter;
    }

    public RepositoryDetails mapToRepositoryDetails(GithubResource resource) {
        return new RepositoryDetails(resource);
    }

    public RepositoryDetails mapToRepositoryDetails(GithubResource resource, ZoneId requestedTimeZone) {
        ZonedDateTime adjustedCreatedAt = timeZoneConverter.adjustToTimeZone(resource.getCreatedAt(), requestedTimeZone);
        return new RepositoryDetails(resource, adjustedCreatedAt);
    }
}
