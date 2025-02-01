package com.example.backend.controller;

import java.util.List;

import com.example.backend.dto.ItemCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.ItemFullDTO;
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
        Item item = itemService.addNewItem(itemCreateDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifyItem(@PathVariable Long id,
                                           @RequestBody ItemFullDTO itemFullDTO) {

        itemService.updateItem(id, itemFullDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
