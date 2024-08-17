package com.example.backend.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
}
