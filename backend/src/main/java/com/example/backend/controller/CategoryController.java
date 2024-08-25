package com.example.backend.controller;

import java.util.List;

import com.example.backend.service.RepositoryManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.service.CategoryService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifyCategory(@PathVariable Long id,
                                               @RequestBody CategoryDTO categoryDTO) {

        categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
