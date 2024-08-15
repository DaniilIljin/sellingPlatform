package com.example.backend.repository;

import com.example.backend.model.Category;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByNameContains(String name);

    List<Category> findByParent(Category category);

    List<Category> findByParentId(Long id);

}
