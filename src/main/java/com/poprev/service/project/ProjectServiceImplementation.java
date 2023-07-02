package com.poprev.service.project;

import com.poprev.data.model.artist.Artist;
import com.poprev.data.model.project.Project;
import com.poprev.data.model.project.ProjectStatus;
import com.poprev.data.model.token.Token;
import com.poprev.data.repository.artist.ArtistRepository;
import com.poprev.data.repository.project.ProjectRepository;
import com.poprev.data.repository.token.TokenRepository;
import com.poprev.service.dto.ProjectDto;
import com.poprev.service.exception.PoprevException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
public class ProjectServiceImplementation implements ProjectService {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TokenRepository tokenRepository;


    private String generateRandomString() {
        return UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 4);
    }

    @Override
    public void createProject(ProjectDto dto) throws PoprevException {

        Artist artist = artistRepository.findById(dto.getArtistId())
                .orElseThrow(() -> new PoprevException("Artist does not exist by that id"));
        Project project = Project.builder()
                .projectStatus(ProjectStatus.valueOf(dto.getProjectStatus()))
                .targetAmount(BigDecimal.valueOf(dto.getTargetAmount()))
                .projectName(dto.getProjectName())
                .artist(artist)
                .build();
        projectRepository.save(project);

        Token token = Token.builder()
                .project(project)
                .tokenName("POPREV-" + generateRandomString())
                .tokenValue(project.getTargetAmount())
                .build();
        tokenRepository.save(token);
    }
}
