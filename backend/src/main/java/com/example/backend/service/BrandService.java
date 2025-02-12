package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Brand;
import org.springframework.stereotype.Service;

import com.example.backend.dto.BrandDTO;
import com.example.backend.mapper.BrandMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

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

    public Brand saveBrand(BrandDTO brandDTO) {
        Brand brand = mapper.convertBrandDTOToBrand(brandDTO);
        return repositoryManager.getBrandRepository().save(brand);
    }

    // захэндлить ситуацию когда пытаются удалить бренд к которому привязаны айтемы
    public void deleteBrand(Long id) {
        Brand brand = repositoryManager
                .getBrandRepository()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand for deleting" +
                        " wasn't found"));

        repositoryManager.getBrandRepository().delete(brand);
    }

    // Здесть надо transactional, тогда можно не вызывать save метод
    @Transactional
    public void updateBrand(Long id, BrandDTO brandDTO) {
        Brand brand = repositoryManager
                .getBrandRepository().
                findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand wasn't found"));
        brand.setName(brandDTO.getName());
    }
}
