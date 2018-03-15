package com.recruitment.task.repository.mapper;

import com.recruitment.task.repository.models.RepositoryResource;
import com.recruitment.task.repository.models.ResourceResponse;

import java.io.IOException;

public interface RepositoryResourceMapper {

    <T extends RepositoryResource> T map(ResourceResponse response, Class<T> requestedClass) throws IOException;
}
