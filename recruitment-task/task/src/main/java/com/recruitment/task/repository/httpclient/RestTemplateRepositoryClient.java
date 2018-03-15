package com.recruitment.task.repository.httpclient;

import com.recruitment.task.repository.models.ResourceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class RestTemplateRepositoryClient implements RepositoryHttpClient {

    private final RestTemplate restTemplate;

    public RestTemplateRepositoryClient(RestTemplate restTemplate) {
        this.restTemplate = Objects.requireNonNull(restTemplate);
    }

    @Override
    public ResourceResponse getResource(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return new ResourceResponse(response.getBody());
    }
}
