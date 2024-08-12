package com.example.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Picture {

    @Id
    private long id;

    private int itemId;
    private String fileName;
    private String fileLocation;
}
