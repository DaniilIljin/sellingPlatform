package com.example.backend.service;

import com.example.backend.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final RepositoryManager repositoryManager;

    public Category getCategoryById(Long id) {

        return repositoryManager.getCategoryRepository().findById(id).get();
    }

    public List<Category> getAllCategories() {
        return repositoryManager.getCategoryRepository().findAll();
    }
}
