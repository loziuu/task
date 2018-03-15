package com.recruitment.task.domain.presentation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepositoryControllerTest {

    @Autowired
    private WebApplicationContext webCtx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webCtx).build();
    }

    @Test
    public void getGithubApiExampleRepository() throws Exception {
        String apiUrl = "http://localhost:8080/repositories/octocat/Hello-world";

        mockMvc.perform(get(apiUrl))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("octocat/Hello-World")))
                .andExpect(jsonPath("$.cloneUrl", is("https://github.com/octocat/Hello-World.git")))
                .andExpect(jsonPath("$.createdAt", is("2011-01-26T19:01:12Z[UTC]")))
                .andExpect(jsonPath("$.stars", is(1446)))
                .andExpect(jsonPath("$.description", is("My first repository on GitHub!")));
    }

    @Test
    public void getGithubApiWithGivenTimeZone() throws Exception {
        String apiUrl = "http://localhost:8080/repositories/octocat/Hello-world";

        mockMvc.perform(get(apiUrl).header("Time-Zone", "America/Chicago"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("octocat/Hello-World")))
                .andExpect(jsonPath("$.cloneUrl", is("https://github.com/octocat/Hello-World.git")))
                .andExpect(jsonPath("$.createdAt", is("2011-01-26T19:01:12-06:00[America/Chicago]")))
                .andExpect(jsonPath("$.stars", is(1446)))
                .andExpect(jsonPath("$.description", is("My first repository on GitHub!")));
    }

    @Test
    public void getNonexistentGithubRepository() throws Exception {
        String apiUrl = "http://localhost:8080/repositories/nonExistingRepositoryOwnerOnGithub/repo";

        mockMvc.perform(get(apiUrl))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Requested repository does not exist.")));
    }
}
