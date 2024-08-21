package com.example.backend.mapper;

import com.example.backend.dto.SizeDTO;
import com.example.backend.model.Size;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SizeMapper {

    private final ModelMapper modelMapper;

    public Size convertSizeDTOToSize(Size sizeDTO) {
        return modelMapper.map(sizeDTO, Size.class);
    }

    public SizeDTO convertSizeToSizeDTO(Size size) {
        return modelMapper.map(size, SizeDTO.class);
    }
}
