package com.example.backend.controller;

import com.example.backend.dto.BrandDTO;
import com.example.backend.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/all")
    public List<BrandDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping
    public BrandDTO getBrand(@RequestParam Long id) {
        return brandService.getBrandById(id);
    }
}
