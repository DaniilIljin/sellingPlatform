package com.example.backend.controller;

import com.example.backend.model.Size;
import com.example.backend.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/size")
public class SizeController {

    private final SizeService sizeService;

    @GetMapping("/all")
    public List<Size> getAllSizes() {
        return sizeService.getAllSizes();
    }

    @GetMapping
    public Size getSize(@RequestParam Long id) {
        return sizeService.getSizeById(id);
    }
}
