package com.recruitment.task.configuration;

import com.recruitment.task.repository.ExternalRepositoryService;
import com.recruitment.task.repository.GithubRepositoryService;
import com.recruitment.task.repository.httpclient.RepositoryHttpClient;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubClientConfiguration {

    private final RepositoriesProperties repositoriesProperties;

    public GithubClientConfiguration(RepositoriesProperties repositoriesProperties) {
        this.repositoriesProperties = repositoriesProperties;
    }

    @Bean
    public ExternalRepositoryService externalRepositoryService(RepositoryHttpClient repositoryHttpClient, RepositoryResourceMapper mapper) {
        String githubApiUrl = repositoriesProperties.getGithub().getApi();
        return new GithubRepositoryService(githubApiUrl, repositoryHttpClient, mapper);
    }
}
