package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.mapper.CategoryMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final RepositoryManager repositoryManager;

    private final CategoryMapper mapper;

    public CategoryDTO getCategoryById(Long id) {

        return repositoryManager
                .getCategoryRepository()
                .findById(id)
                .map(mapper::convertCategoryToCategoryDTO)
                .orElseThrow(() -> new EntityNotFoundException("Category wasn't found"));

    }

    public List<CategoryDTO> getAllCategories() {

        return repositoryManager
                .getCategoryRepository()
                .findAllByParentIdNull()
                .stream()
                .map(mapper::convertCategoryToCategoryDTO)
                .toList();
    }
}
