package com.example.backend.controller;

import com.example.backend.model.Item;
import com.example.backend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping
    public Item getItemById(@RequestParam Long id) {
        return itemService.getItemById(id);
    }
}
