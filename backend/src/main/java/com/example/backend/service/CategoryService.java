package com.example.backend.service;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.mapper.CategoryMapper;
import com.example.backend.model.Category;
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

        return mapper.
                convertCategoryToCategoryDTO(repositoryManager.
                        getCategoryRepository().
                        findById(id).
                        get());

    }

    public List<CategoryDTO> getAllCategories() {
        return repositoryManager.
                getCategoryRepository().
                findAll().
                stream().
                map(mapper::convertCategoryToCategoryDTO).
                toList();
    }
}
