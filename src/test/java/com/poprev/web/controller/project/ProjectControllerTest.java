package com.poprev.web.controller.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poprev.service.dto.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    String token = "";

    @Test
    void createProject() throws Exception {
        ProjectDto dto = ProjectDto.builder()
                .projectName("Naija Made")
                .projectStatus("APPROVED")
                .artistId(1L)
                .targetAmount(1000000.00)
                .build();
        mockMvc.perform(post("/projects")
                        .header("Authorization")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}