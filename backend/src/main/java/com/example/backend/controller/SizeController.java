package com.example.backend.controller;

import com.example.backend.dto.SizeDTO;
import com.example.backend.model.Size;
import com.example.backend.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/size")
public class SizeController {

    private final SizeService sizeService;

    @GetMapping("/all")
    public List<SizeDTO> getAllSizes() {
        return sizeService.getAllSizes();
    }

    @GetMapping("/{id}")
    public SizeDTO getSize(@PathVariable Long id) {
        return sizeService.getSizeById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createSize(@RequestBody SizeDTO sizeDTO) {
        Size size = sizeService.saveSize(sizeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSize(@PathVariable Long id) {
        sizeService.deleteSize(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modofySize(@PathVariable Long id,
                                           @RequestBody SizeDTO sizeDTO) {

        sizeService.updateSize(id, sizeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
