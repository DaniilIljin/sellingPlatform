package com.example.backend.repository;

import com.example.backend.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Long> {

    List<Size> findByNameContains(String name);
}
