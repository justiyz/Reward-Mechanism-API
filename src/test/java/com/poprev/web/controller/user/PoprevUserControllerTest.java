package com.poprev.web.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poprev.service.dto.CreateUserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class PoprevUserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }


    @Test
    void registerUserEndpoint() throws Exception {
        CreateUserDto dto = CreateUserDto.builder()
                .email("bj@gmail.com")
                .userType("USER")
                .username("beejay")
                .password("user123")
                .build();
        mockMvc.perform(post("/projects")
                        .header("Authorization")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void test_findUserByIdEndPoint() throws Exception {

        this.mockMvc.perform(get("/users/1")

                        .header("Authorization"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void test_findAllUsers() throws Exception {
        this.mockMvc.perform(get("/users/all")
                        .header("Authorization"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}