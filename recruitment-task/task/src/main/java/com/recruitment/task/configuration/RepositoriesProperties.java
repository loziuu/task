package com.recruitment.task.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "task")
@Validated
public class RepositoriesProperties {

    private final Github github = new Github();

    public Github getGithub() {
        return github;
    }

    public static class Github {

        @NotNull
        private String api;

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }
    }
}
