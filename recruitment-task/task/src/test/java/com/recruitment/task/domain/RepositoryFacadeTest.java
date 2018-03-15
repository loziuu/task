package com.recruitment.task.domain;

import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.fixtures.InMemoryExternalRepositoryService;
import com.recruitment.task.fixtures.TestFixtures;
import com.recruitment.task.repository.models.GithubResource;
import com.recruitment.task.repository.models.RepositoryRequestDTO;
import com.recruitment.task.repository.models.RepositoryResource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class RepositoryFacadeTest {

    private RepositoryFacade facade;

    @Before
    public void setup() {
        TimeZoneConverter converter = new TimeZoneConverter();
        Baklazan baklazan = new Baklazan(converter);
        InMemoryExternalRepositoryService service = new InMemoryExternalRepositoryService(getStubRepositories());
        facade = new GithubRepositoryFacade(service, baklazan);
    }

    @Test
    public void getRepositoryDetails() throws IOException {
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");

        RepositoryDetails details = facade.getRepositoryResource(requestDTO);

        assertEquals(details.getFullName(), "owner/repository");
    }

    @Test
    public void getRepositoryDetailsWithAdjustedTimeZone() throws IOException {
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");
        String requestedTimeZone = "CET";
        RequestOptions options = new RequestOptions(requestedTimeZone);

        RepositoryDetails details = facade.getRepositoryResource(requestDTO, options);

        assertEquals(details.getCreatedAt().getZone(), options.getTimeZone());
    }

    @Test
    public void getRepositoryDetilasWithNullTimeZonesOptions() throws IOException {
        GithubResource resource = TestFixtures.getGithubResource();
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");
        RequestOptions options = new RequestOptions(null);

        RepositoryDetails details = facade.getRepositoryResource(requestDTO, options);

        assertEquals(details.getCreatedAt(), resource.getCreatedAt());
    }

    public HashMap<String, RepositoryResource> getStubRepositories() {
        HashMap<String, RepositoryResource> repositories = new HashMap<>();
        repositories.put("owner/repository", TestFixtures.getGithubResource());
        return repositories;
    }
}
