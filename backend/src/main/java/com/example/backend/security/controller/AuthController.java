package com.example.backend.security.controller;

import com.example.backend.dto.JwtResponseDTO;
import com.example.backend.dto.TokenRefreshRequestDTO;
import com.example.backend.dto.UserLoginDTO;
import com.example.backend.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO) {

        return new ResponseEntity<>(
                authService.authenticateUser(userLoginDTO),
                HttpStatus.OK
        );

    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtResponseDTO> refreshToken(@RequestBody TokenRefreshRequestDTO request) {

        return new ResponseEntity<>(
                authService.updateTokens(request.getRefreshToken()),
                HttpStatus.OK
        );
    }
}
