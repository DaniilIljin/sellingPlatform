package com.example.backend.repository;

import com.example.backend.model.Category;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameContains(String name);

    List<Category> findAllByParentId(Long parentId);

    Optional<Category> findByNameEquals(String name);

}
