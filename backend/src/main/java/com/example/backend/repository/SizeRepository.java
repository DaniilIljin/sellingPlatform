package com.example.backend.repository;

import com.example.backend.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, Long> {

    List<Size> findAllByNameContains(String name);

    Optional<Size> findByNameEquals(String name);
}
