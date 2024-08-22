package com.example.backend.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String categoryName;
}
