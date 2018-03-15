package com.recruitment.task.domain;

import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.fixtures.TestFixtures;
import com.recruitment.task.repository.models.GithubResource;
import org.junit.Before;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class BaklazanTest {

    private Baklazan baklazan;

    @Before
    public void setup() {
        TimeZoneConverter timeZoneConverter = new TimeZoneConverter();
        baklazan = new Baklazan(timeZoneConverter);
    }

    @Test
    public void mapRepositoryResourceToRepositoryDetails() {
        GithubResource resource = TestFixtures.getGithubResource();

        RepositoryDetails details = baklazan.mapToRepositoryDetails(resource);

        assertEquals(details.getFullName(), resource.getFullName());
        assertEquals(details.getDescription(), resource.getDescription());
        assertEquals(details.getCloneUrl(), resource.getCloneUrl());
        assertEquals(details.getStars(), resource.getStars());
        assertEquals(details.getCreatedAt(), resource.getCreatedAt());
    }

    @Test
    public void mapRepositoryResourceToRepositoryDetailsWithDifferentTimeZone() {
        ZoneId requestedTimeZone = ZoneId.of("America/Chicago");
        GithubResource resource = TestFixtures.getGithubResource();

        RepositoryDetails details = baklazan.mapToRepositoryDetails(resource, requestedTimeZone);

        assertEquals(details.getFullName(), resource.getFullName());
        assertEquals(details.getDescription(), resource.getDescription());
        assertEquals(details.getCloneUrl(), resource.getCloneUrl());
        assertEquals(details.getStars(), resource.getStars());
        assertEquals(details.getCreatedAt().getZone(), requestedTimeZone);
    }
}
