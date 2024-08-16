package com.example.backend.service;

import com.example.backend.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final RepositoryManager repositoryManager;

    public Brand getBrandById(Long id) {
        return repositoryManager.getBrandRepository().findById(id).get();
    }

    public List<Brand> getAllBrands() {
        return repositoryManager.getBrandRepository().findAll();
    }
}
