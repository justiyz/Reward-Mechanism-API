package com.poprev.web.controller.artist;

import com.poprev.service.artist.ArtistServiceImplementation;
import com.poprev.service.dto.ArtistDto;
import com.poprev.service.dto.ProjectDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.web.response.ResponseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    ArtistServiceImplementation artistServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> createArtist(@RequestBody ArtistDto dto) throws PoprevException {
        artistServiceImpl.createArtist(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Artist created", "success");
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }
}
