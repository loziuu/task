package com.recruitment.task.fixtures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment.task.repository.GithubRepositoryService;
import com.recruitment.task.repository.httpclient.RepositoryHttpClient;
import com.recruitment.task.repository.httpclient.RestTemplateRepositoryClient;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import com.recruitment.task.repository.mapper.RepositoryResourceObjectMapper;
import com.recruitment.task.repository.models.GithubResource;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;

public class TestFixtures {

    private final static String apiUrl = "http://example.org/repos";

    public static GithubRepositoryService getGithubRepositoryService() {
        RepositoryHttpClient httpClient = getRepositoryHttpClient();
        RepositoryResourceMapper mapper = getRepositoryResourceMapper();
        return new GithubRepositoryService(apiUrl, httpClient, mapper);
    }

    public static RepositoryHttpClient getRepositoryHttpClient() {
        RestTemplate restTemplate = new RestTemplate();
        return new RestTemplateRepositoryClient(restTemplate);
    }

    public static RepositoryResourceMapper getRepositoryResourceMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new RepositoryResourceObjectMapper(objectMapper);
    }

    public static GithubResource getGithubResource() {
        return new GithubResource("owner/repository", "Description",
                "http://example.org/repos/owner/repository", 5,
                ZonedDateTime.parse("2011-01-26T19:01:12Z[UTC]"));
    }
}
