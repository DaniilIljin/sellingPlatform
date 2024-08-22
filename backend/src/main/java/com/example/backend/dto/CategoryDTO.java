package com.example.backend.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    //private Long parentId;
    //private String parentName;
    private List<CategoryDTO> subcategories;
}
