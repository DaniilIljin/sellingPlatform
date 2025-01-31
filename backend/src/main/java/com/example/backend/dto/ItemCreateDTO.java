package com.example.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ItemCreateDTO {

    private Long categoryId;
    private Long sizeId;
    private Long brandId;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> pictureNames;
}
