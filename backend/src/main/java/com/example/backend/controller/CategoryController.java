package com.example.backend.controller;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.model.Category;
import com.example.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public CategoryDTO getCategory(@RequestParam Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
