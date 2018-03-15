package com.recruitment.task.configuration;

import com.recruitment.task.domain.Baklazan;
import com.recruitment.task.domain.GithubRepositoryFacade;
import com.recruitment.task.domain.RepositoryFacade;
import com.recruitment.task.repository.ExternalRepositoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryGatewayConfiguration {

    private final ExternalRepositoryService repositoryService;
    private final Baklazan baklazan;

    public RepositoryGatewayConfiguration(ExternalRepositoryService repositoryService, Baklazan baklazan) {
        this.repositoryService = repositoryService;
        this.baklazan = baklazan;
    }

    @Bean
    public RepositoryFacade repositoryGateway() {
        return new GithubRepositoryFacade(repositoryService, baklazan);
    }
}
