package com.example.backend.mapper;

import com.example.backend.dto.BrandDTO;
import com.example.backend.model.Brand;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandMapper {

    private final ModelMapper modelMapper;

    public BrandDTO convertBrandToBrandDTO (Brand brand) {
        return modelMapper.map(brand, BrandDTO.class);
    }

    public Brand convertBrandDTOToBrand (BrandDTO brandDTO) {
        return modelMapper.map(brandDTO, Brand.class);
    }

}
