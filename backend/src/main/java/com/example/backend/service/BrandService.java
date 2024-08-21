package com.example.backend.service;

import com.example.backend.dto.BrandDTO;
import com.example.backend.mapper.BrandMapper;
import com.example.backend.model.Brand;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final RepositoryManager repositoryManager;

    private final BrandMapper mapper;

    public BrandDTO getBrandById(Long id) {
        return repositoryManager
                .getBrandRepository()
                .findById(id)
                .map(mapper::convertBrandToBrandDTO)
                .orElseThrow(() -> new EntityNotFoundException("Brand wasn't found"));
    }

    public List<BrandDTO> getAllBrands() {
        return repositoryManager
                .getBrandRepository()
                .findAll()
                .stream()
                .map(mapper::convertBrandToBrandDTO)
                .toList();
    }
}
