package com.poprev.web.controller.project;

import com.poprev.service.dto.ProjectDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.project.ProjectServiceImplementation;
import com.poprev.web.response.ResponseDetails;
import com.poprev.web.response.ResponseDetailsWithObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectServiceImplementation projectServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectDto dto) throws PoprevException {

        projectServiceImpl.createProject(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Project created", "success");
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }
}
