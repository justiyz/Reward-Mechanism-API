package com.poprev.service.artist;

import com.poprev.service.dto.ArtistDto;
import com.poprev.service.exception.PoprevException;

public interface ArtistService {

    void createArtist(ArtistDto dto) throws PoprevException;
}
