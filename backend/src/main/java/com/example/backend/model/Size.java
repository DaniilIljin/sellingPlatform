package com.example.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Size {

    @Id
    private long id;

    private String name;
}
