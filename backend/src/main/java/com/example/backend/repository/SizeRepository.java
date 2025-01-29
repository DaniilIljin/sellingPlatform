package com.example.backend.repository;

import com.example.backend.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    List<Size> findAllByNameContains(String name);

    Optional<Size> findByNameEquals(String name);
}
