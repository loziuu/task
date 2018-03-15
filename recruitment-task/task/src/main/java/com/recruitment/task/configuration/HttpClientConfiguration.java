package com.recruitment.task.configuration;

import com.recruitment.task.repository.httpclient.RepositoryHttpClient;
import com.recruitment.task.repository.httpclient.RestTemplateRepositoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RepositoryHttpClient httpClient(RestTemplate restTemplate) {
        return new RestTemplateRepositoryClient(restTemplate);
    }
}
