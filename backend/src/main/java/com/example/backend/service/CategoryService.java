package com.example.backend.service;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.mapper.CategoryMapper;
import com.example.backend.model.Category;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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
                .findAll()
                .stream()
                .map(mapper::convertCategoryToCategoryDTO)
                .toList();
    }
}
