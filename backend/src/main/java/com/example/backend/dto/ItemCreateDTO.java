package com.example.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemCreateDTO {

    private String name;
    private Long categoryId;
    private Long sizeId;
    private Long brandId;
    private Long sellerId;
    private String description;
    private BigDecimal price;
}
