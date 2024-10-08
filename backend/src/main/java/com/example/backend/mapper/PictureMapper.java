package com.example.backend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.backend.dto.PictureDTO;
import com.example.backend.model.Picture;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PictureMapper {

    private final ModelMapper modelMapper;

    public Picture convertPictureDTOToPicture(PictureDTO pictureDTO) {
        return modelMapper.map(pictureDTO, Picture.class);
    }

    public PictureDTO convertPictureToPictureDTO(Picture picture) {
        return modelMapper.map(picture, PictureDTO.class);
    }

}
