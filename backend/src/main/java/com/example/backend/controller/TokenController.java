package com.example.backend.controller;

import com.example.backend.dto.JwtResponseDTO;
import com.example.backend.security.service.AuthService;
import com.example.backend.security.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class TokenController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    
    @PostMapping
    public JwtResponseDTO refreshToken(@RequestBody String refreshToken) {
        // тут решить что возвращать если рефреш токен не действителен
        // сервис мб ошибку выдает если не действителен или сделать так чтобы выдавал
        // так анверное лучшеe
        return refreshTokenService.validateRefreshToken(refreshToken.substring(1, refreshToken.length() - 1));

    }
}
