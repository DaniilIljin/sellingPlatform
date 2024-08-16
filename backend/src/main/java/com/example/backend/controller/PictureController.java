package com.example.backend.controller;

import com.example.backend.model.Picture;
import com.example.backend.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/picture")
public class PictureController {

    private final PictureService pictureService;

    @GetMapping("/all")
    public List<Picture> getAllPictures() {
        return pictureService.getAllPictures();
    }

    @GetMapping
    public Picture getPicture(@RequestParam Long id) {
        return pictureService.getPictureById(id);
    }
}
