package com.poprev.service.project;

import com.poprev.service.dto.ProjectDto;
import com.poprev.service.exception.PoprevException;

public interface ProjectService {

    void createProject(ProjectDto dto) throws PoprevException;
}
