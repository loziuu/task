package com.recruitment.task.repository;

import com.recruitment.task.repository.models.RepositoryRequestDTO;
import com.recruitment.task.repository.models.RepositoryResource;

import java.io.IOException;

public interface ExternalRepositoryService {
    <T extends RepositoryResource> T getRepositoryResource(RepositoryRequestDTO requestDTO, Class<T> resourceClass) throws IOException;
}
