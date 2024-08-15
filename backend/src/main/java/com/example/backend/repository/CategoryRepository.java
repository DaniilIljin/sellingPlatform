package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> getByNameContains(String name);

    List<Category> getByParent(Category category);

    List<Category> findParentId(Long id);

}
