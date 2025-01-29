package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameContains(String name);

    List<Category> findAllByParentId(Long parentId);

    Optional<Category> findByNameEquals(String name);

    //@EntityGraph(attributePaths = "parent")
    List<Category> findAll();

    //@EntityGraph(attributePaths = "parent")
    Optional<Category> findById(Long id);

    List<Category> findAllByParentIdNull();
}
