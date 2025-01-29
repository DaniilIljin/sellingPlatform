package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Picture;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    List<Picture> findAllByItemId(Long itemId);

    List<Picture> findAllByFileNameContaining(String fileName);

    List<Picture> findAllByFileLocationContains(String fileLocation);

    Optional<Picture> findByFileNameEquals(String fileName);

    Optional<Picture> findByFileLocationEquals(String fileLocation);

}
