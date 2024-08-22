package com.example.backend.controller;

import com.example.backend.dto.ItemDTO;
import com.example.backend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<ItemDTO> getItemsByCategoryId(@PathVariable Long categoryId) {
        return itemService.getItemsByCategoryId(categoryId);
    }
}
