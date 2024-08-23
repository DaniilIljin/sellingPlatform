package com.example.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ItemCreateDTO;
import com.example.backend.dto.ItemDTO;
import com.example.backend.model.Item;
import com.example.backend.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
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
