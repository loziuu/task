package com.recruitment.task.repository;

import com.recruitment.task.repository.models.RepositoryRequestDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryRequestDtoTest {

    @Test
    public void constructWithProperValues() {
        RepositoryRequestDTO requestDTO = new RepositoryRequestDTO("owner", "repository");

        assertEquals(requestDTO.getOwner(), "owner");
        assertEquals(requestDTO.getRepositoryName(), "repository");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructWithBlankOwner() {
        new RepositoryRequestDTO("", "repository");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructWithBlankRepositoryName() {
        new RepositoryRequestDTO("owner", "");
    }
}
