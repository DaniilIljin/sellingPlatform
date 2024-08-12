package com.example.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category {

    @Id
    private long id;

    private String name;
    private int categoryId;
}
