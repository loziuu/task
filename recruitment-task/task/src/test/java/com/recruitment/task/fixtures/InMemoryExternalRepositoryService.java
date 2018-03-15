package com.recruitment.task.fixtures;

import com.recruitment.task.repository.ExternalRepositoryService;
import com.recruitment.task.repository.models.RepositoryRequestDTO;
import com.recruitment.task.repository.models.RepositoryResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class InMemoryExternalRepositoryService implements ExternalRepositoryService {

    private final HashMap<String, RepositoryResource> repositories;

    public InMemoryExternalRepositoryService(HashMap<String, RepositoryResource> repositories) {
        this.repositories = repositories;
    }

    @Override
    public <T extends RepositoryResource> T getRepositoryResource(RepositoryRequestDTO requestDTO, Class<T> resourceClass) throws IOException {
        String resourcesKey = String.format("%s/%s", requestDTO.getOwner(), requestDTO.getRepositoryName());
        Optional<RepositoryResource> foundRepository = Optional.ofNullable(repositories.get(resourcesKey));
        return (T) foundRepository.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
