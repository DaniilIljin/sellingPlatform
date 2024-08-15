package com.example.backend.repository;

import com.example.backend.model.Item;
import com.example.backend.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {

    List<Picture> findByItem(Item item);

    List<Picture> findByItemId(Long itemId);
}
