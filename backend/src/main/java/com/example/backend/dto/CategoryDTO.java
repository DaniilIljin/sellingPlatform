package com.example.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private Long parentId;
    //private String parentName;
    private List<CategoryDTO> subcategories;
}
