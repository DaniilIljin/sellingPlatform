package com.example.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LikedItems {

    @Id
    private long id;

    private int userId;
    private int itemId;
}
