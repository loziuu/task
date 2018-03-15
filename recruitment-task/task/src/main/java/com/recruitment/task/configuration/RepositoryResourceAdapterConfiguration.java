package com.recruitment.task.configuration;

import com.recruitment.task.domain.Baklazan;
import com.recruitment.task.domain.TimeZoneConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryResourceAdapterConfiguration {

    @Bean
    public TimeZoneConverter timeZoneConverter() {
        return new TimeZoneConverter();
    }

    @Bean
    public Baklazan repositoryResourceAdapter(TimeZoneConverter converter) {
        return new Baklazan(converter);
    }
}
