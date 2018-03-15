package com.recruitment.task.domain;

import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.repository.ExternalRepositoryService;
import com.recruitment.task.repository.models.GithubResource;
import com.recruitment.task.repository.models.RepositoryRequestDTO;

import java.io.IOException;

public class GithubRepositoryFacade implements RepositoryFacade {

    private final ExternalRepositoryService repositoryService;
    private final Baklazan baklazan;

    public GithubRepositoryFacade(ExternalRepositoryService repositoryService, Baklazan baklazan) {
        this.repositoryService = repositoryService;
        this.baklazan = baklazan;
    }

    @Override
    public RepositoryDetails getRepositoryResource(RepositoryRequestDTO requestDTO) throws IOException {
        return getRepositoryResource(requestDTO, new RequestOptions(null));
    }

    @Override
    public RepositoryDetails getRepositoryResource(RepositoryRequestDTO requestDTO, RequestOptions options) throws IOException {
        GithubResource resource = repositoryService.getRepositoryResource(requestDTO, GithubResource.class);
        if (options.getTimeZone() == null)
            return baklazan.mapToRepositoryDetails(resource);
        return baklazan.mapToRepositoryDetails(resource, options.getTimeZone());
    }
}
