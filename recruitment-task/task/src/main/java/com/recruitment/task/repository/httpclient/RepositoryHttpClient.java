package com.recruitment.task.repository.httpclient;

import com.recruitment.task.repository.models.ResourceResponse;

public interface RepositoryHttpClient {

    ResourceResponse getResource(String url);

}
