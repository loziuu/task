package com.recruitment.task.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import com.recruitment.task.repository.mapper.RepositoryResourceObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RepositoryObjectMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true);
        return objectMapper;
    }

    @Bean
    public RepositoryResourceMapper repositoryResourceMapper(ObjectMapper objectMapper) {
        return new RepositoryResourceObjectMapper(objectMapper);
    }
}
