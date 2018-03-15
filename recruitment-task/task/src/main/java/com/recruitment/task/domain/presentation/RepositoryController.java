package com.recruitment.task.domain.presentation;

import com.recruitment.task.domain.RepositoryFacade;
import com.recruitment.task.domain.RequestOptions;
import com.recruitment.task.domain.models.RepositoryDetails;
import com.recruitment.task.repository.models.RepositoryRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("repositories")
public class RepositoryController {

    private final RepositoryFacade repositoryFacade;

    public RepositoryController(RepositoryFacade repositoryFacade) {
        this.repositoryFacade = repositoryFacade;
    }

    @GetMapping("{owner}/{repositoryName}")
    public ResponseEntity<RepositoryDetails> getRepositoryDetails(@PathVariable String owner,
                                                                  @PathVariable String repositoryName,
                                                                  @RequestHeader(value = "Time-Zone", required = false) String timeZone) throws IOException {
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO(owner, repositoryName);
        RequestOptions options = new RequestOptions(timeZone);
        RepositoryDetails repositoryDetails = repositoryFacade.getRepositoryResource(requestDTO, options);
        return ResponseEntity.ok(repositoryDetails);
    }
}
