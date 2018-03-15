package com.recruitment.task.domain;

import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.repository.models.RepositoryRequestDTO;

import java.io.IOException;

public interface RepositoryFacade {
    RepositoryDetails getRepositoryResource(RepositoryRequestDTO requestDTO) throws IOException;

    RepositoryDetails getRepositoryResource(RepositoryRequestDTO requestDTO, RequestOptions options) throws IOException;
}
