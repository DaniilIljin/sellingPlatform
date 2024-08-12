package com.example.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Item {

    @Id
    private long id;// или long

    private int categoryId;
    private int sizeId;
    private int brandId;
    private int sellerId;
    private String name;
    //private int status;
    private String description;
    private BigDecimal price;
    //private int orderStatus;
    private int userId;

}
