package com.recruitment.task.repository.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment.task.repository.models.RepositoryResource;
import com.recruitment.task.repository.models.ResourceResponse;

import java.io.IOException;
import java.util.Objects;

public class RepositoryResourceObjectMapper implements RepositoryResourceMapper {

    private final ObjectMapper objectMapper;

    public RepositoryResourceObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = Objects.requireNonNull(objectMapper);
    }

    @Override
    public <T extends RepositoryResource> T map(ResourceResponse response, Class<T> requestedClass) throws IOException {
        return objectMapper.readValue(response.getBody(), requestedClass);
    }
}
