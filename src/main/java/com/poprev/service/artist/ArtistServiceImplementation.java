package com.poprev.service.artist;

import com.poprev.data.model.artist.Artist;
import com.poprev.data.repository.artist.ArtistRepository;
import com.poprev.service.dto.ArtistDto;
import com.poprev.service.exception.PoprevException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImplementation implements ArtistService{

    @Autowired
    ArtistRepository artistRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createArtist(ArtistDto dto) throws PoprevException {
        Artist artist = modelMapper.map(dto, Artist.class);
        artistRepository.save(artist);
    }
}
