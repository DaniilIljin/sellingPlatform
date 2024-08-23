package com.example.backend.controller;

import com.example.backend.dto.ItemCreateDTO;
import com.example.backend.dto.ItemDTO;
import com.example.backend.model.Item;
import com.example.backend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody ItemCreateDTO itemCreateDTO) {

        Item item = itemService.saveItem(itemCreateDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
