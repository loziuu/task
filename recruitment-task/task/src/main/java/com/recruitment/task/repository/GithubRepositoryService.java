package com.recruitment.task.repository;

import com.recruitment.task.repository.httpclient.RepositoryHttpClient;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import com.recruitment.task.repository.models.RepositoryRequestDTO;
import com.recruitment.task.repository.models.RepositoryResource;
import com.recruitment.task.repository.models.ResourceResponse;

import java.io.IOException;
import java.util.Objects;

public class GithubRepositoryService implements ExternalRepositoryService {

    private final String apiUrl;
    private final RepositoryHttpClient client;
    private final RepositoryResourceMapper mapper;

    public GithubRepositoryService(String apiUrl, RepositoryHttpClient client, RepositoryResourceMapper mapper) {
        this.apiUrl = Objects.requireNonNull(apiUrl);
        this.client = Objects.requireNonNull(client);
        this.mapper = Objects.requireNonNull(mapper);
    }

    @Override
    public <T extends RepositoryResource> T getRepositoryResource(RepositoryRequestDTO requestDTO, Class<T> resourceClass) throws IOException {
        Objects.requireNonNull(resourceClass);
        String url = apiUrl + String.format("/%s/%s", requestDTO.getOwner(), requestDTO.getRepositoryName());
        ResourceResponse response = client.getResource(url);
        return mapper.map(response, resourceClass);
    }
}
