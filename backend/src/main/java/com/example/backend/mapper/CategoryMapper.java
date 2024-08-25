package com.example.backend.mapper;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.model.Category;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final ModelMapper modelMapper;

    private final EntityManager entityManager;

//    public Category convertCategoryDTOToCategory(CategoryDTO categoryDTO) {
//        return modelMapper.map(categoryDTO, Category.class);
//    }

    public CategoryDTO convertCategoryToCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public Category convertCategoryDTOToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        if (categoryDTO.getParentId() == null) category.setParent(null);
        else {
            Category parent = entityManager.getReference(Category.class, categoryDTO.getParentId());
            category.setParent(parent);
        }

        return category;
    }
}
