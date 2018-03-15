package com.recruitment.task.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment.task.repository.models.GithubResource;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import com.recruitment.task.repository.mapper.RepositoryResourceObjectMapper;
import com.recruitment.task.repository.models.ResourceResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class RepositoryResourceMapperTest {

    private RepositoryResourceMapper mapper;

    @Before
    public void setup() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        mapper = new RepositoryResourceObjectMapper(objectMapper);
    }

    @Test
    public void mapFullNameJsonResponseToPojo() throws IOException {
        String fullName = "owner/Example-repository";
        ResourceResponse givenResponse = new ResourceResponse("{\"full_name\":\"" + fullName + "\"}");

        GithubResource response = mapper.map(givenResponse, GithubResource.class);

        assertEquals(response.getFullName(), fullName);
    }

    @Test
    public void mapDescriptionJsonResponseToPojo() throws IOException {
        String description = "Repository example description.";
        ResourceResponse givenResponse = new ResourceResponse("{\"description\":\"" + description + "\"}");

        GithubResource response = mapper.map(givenResponse, GithubResource.class);

        assertEquals(response.getDescription(), description);
    }

    @Test
    public void mapCloneUrlJsonResponseToPojo() throws IOException {
        String cloneUrl = "http://example.org";
        ResourceResponse givenResponse = new ResourceResponse("{\"clone_url\":\"" + cloneUrl + "\"}");

        GithubResource response = mapper.map(givenResponse, GithubResource.class);

        assertEquals(response.getCloneUrl(), cloneUrl);
    }

    @Test
    public void mapStarsCountJsonResponseToPojo() throws IOException {
        int stars = 5;
        ResourceResponse givenResponse = new ResourceResponse("{\"stargazers_count\":\"" + stars + "\"}");

        GithubResource response = mapper.map(givenResponse, GithubResource.class);

        assertEquals(response.getStars(), stars);
    }

    @Test
    public void mapCreatedAtJsonResponseToPojo() throws IOException {
        ZonedDateTime createdAt = ZonedDateTime.parse("2011-01-26T19:01:12Z");

        ResourceResponse givenResponse = new ResourceResponse("{\"created_at\":\"" + "2011-01-26T19:01:12Z" + "\"}");

        GithubResource response = mapper.map(givenResponse, GithubResource.class);

        assertEquals(response.getCreatedAt(), createdAt);
    }
}
