package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Category;
import jakarta.persistence.EntityManager;
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

    // разобраться с методоми в mapper для всех энтитис, там можно сделать лучше
    // чтобы все через них мапилось
    public Category saveCategory(CategoryDTO categoryDTO) {
        Category category = mapper.convertCategoryDTOToNewCategory(categoryDTO);
        return repositoryManager
                .getCategoryRepository()
                .save(category);
    }

    public void deleteCategory(Long id) {
        Category category = repositoryManager
                .getCategoryRepository()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category for deleting" +
                        "wasn't found"));

        repositoryManager.getCategoryRepository().delete(category);
    }

    public void updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = repositoryManager
                .getCategoryRepository()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category for updating" +
                        "wasn't found"));

        category.setName(categoryDTO.getName());
        if (categoryDTO.getParentId() == null) category.setParent(null);
        else {
            Category parent = repositoryManager
                    .getCategoryRepository()
                    .getReferenceById(categoryDTO.getParentId());
            category.setParent(parent);
        }

        repositoryManager
                .getCategoryRepository()
                .save(category);
    }

}
