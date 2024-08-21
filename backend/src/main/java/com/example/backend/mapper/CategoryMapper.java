package com.example.backend.mapper;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.model.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final ModelMapper modelMapper;

    public Category convertCategoryDTOToCategory(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO convertCategoryToCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}
