package com.example.backend.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {

    private final String name;
    private final String password;
    private final String email;
    private final String address;
    private final String additionalInfo;

}
