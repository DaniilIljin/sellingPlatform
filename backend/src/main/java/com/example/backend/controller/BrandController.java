package com.example.backend.controller;

import com.example.backend.dto.BrandDTO;
import com.example.backend.model.Brand;
import com.example.backend.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BrandDTO getBrand(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createBrand(@RequestBody BrandDTO brandDTO) {
        Brand brand = brandService.saveBrand(brandDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifyBrand(@PathVariable Long id,
                                            @RequestBody BrandDTO brandDTO) {

        brandService.updateBrand(id, brandDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
