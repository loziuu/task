package com.recruitment.task.repository;

import com.recruitment.task.fixtures.FakeResource;
import com.recruitment.task.fixtures.TestFixtures;
import com.recruitment.task.repository.httpclient.RepositoryHttpClient;
import com.recruitment.task.repository.httpclient.RestTemplateRepositoryClient;
import com.recruitment.task.repository.mapper.RepositoryResourceMapper;
import com.recruitment.task.repository.models.RepositoryRequestDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class ExternalRepositoryServiceTest {
    private final String apiUrl = "http://example.org/repos/";
    private final RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");

    private MockRestServiceServer mockServer;
    private ExternalRepositoryService repositoryService;

    @Before
    public void setup() {
        RestTemplate restTemplate = new RestTemplate();
        RepositoryHttpClient httpClient = new RestTemplateRepositoryClient(restTemplate);
        RepositoryResourceMapper mapper = TestFixtures.getRepositoryResourceMapper();
        mockServer = MockRestServiceServer.createServer(restTemplate);
        repositoryService = new GithubRepositoryService(apiUrl, httpClient, mapper);
    }

    @Test
    public void getTestResourceObjectFromMockedServerJsonResponse() throws IOException {
        String repositoryFullName = String.format("%s/%s", requestDTO.getOwner(), requestDTO.getRepositoryName());
        mockServer.expect(requestTo(apiUrl + repositoryFullName))
                .andRespond(withSuccess("{ \"full_name\": \"" + repositoryFullName + "\" }", MediaType.APPLICATION_JSON));

        FakeResource resource = repositoryService.getRepositoryResource(requestDTO, FakeResource.class);

        mockServer.verify();
        assertEquals(resource.getFullName(), repositoryFullName);
    }

    @Test(expected = NullPointerException.class)
    public void getNullObjectShouldThrowException() throws IOException {
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");
        repositoryService.getRepositoryResource(requestDTO, null);
    }
}
